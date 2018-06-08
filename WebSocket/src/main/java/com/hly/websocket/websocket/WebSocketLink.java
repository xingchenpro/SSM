package com.hly.websocket.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author :hly
 * @date :2018/5/17
 * 作者博客：https://blog.csdn.net/Sirius_hly
 */

/**
 * @author uptop
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */

@ServerEndpoint(value = "/websocket", configurator = HttpSessionConfigurator.class)
public class WebSocketLink {
    //在线people
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static CopyOnWriteArraySet<WebSocketLink> webSocketSet = new CopyOnWriteArraySet<WebSocketLink>();
    //与某个客户端的链接会话，需要通过它来给客户端发送数据
    private Session session;
    private String userId;//用户
    private HttpSession httpSession;//request的Session
    private static List list = new ArrayList();//在线用户
    private static Map userSessions = new HashMap();//用户名和websocket的Session绑定

    //建立链接创建方法
    //session可选，某个客户端的连接会话，需要他给客户端发送消息
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.session = session;
        webSocketSet.add(this);//加入set
        addOnlineCount();//在线人数
        //得到httpsession
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.userId = (String) httpSession.getAttribute("userId");//获得当前用户
        list.add(userId);//添加在线用户
        userSessions.put(userId, session);//将用户和Session绑定
        //String message = toChatweb("【" + userId + "】加入聊天,当前在线人数为" + getOnlineCount(), "notice", list);
        //broadcastMsg(message);
        System.out.println("又有二五仔加入了！当前在线人数为" + getOnlineCount());
    }

    //连接关闭调用
    @OnClose
    public void onClode() {
        webSocketSet.remove(this);
        subOnlineCount();
        list.remove(userId);
        userSessions.remove(userId);
       //String message = toChatweb("【" + userId + "】离开聊天,当前在线人数为" + getOnlineCount(), "notice", list);
        //broadcastMsg(message);
        System.out.println("有一个二五仔掉线了！当前在线人数为" + getOnlineCount());

    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("错误了，是网线断了吗");
        error.printStackTrace();
    }

    //收到消息
    //msg是收到的json对象，和下面要发过去的json对象相同
    @OnMessage
    public void onMessage(String msg, Session session) {
        System.out.println("客户端的消息" + msg);
        //JSON字符串转化为对象
        JSONObject chat = JSON.parseObject(msg);
        JSONObject message = JSON.parseObject(chat.get("message").toString());
        if (message.get("to") == null || message.get("to").equals("")) {
            broadcastMsg(msg);
        } else {
            String[] userList = message.get("to").toString().split(",");
            for (String user : userList) {
                if (!user.equals(message.get("from"))) {
                    singleMsg(msg, (Session) userSessions.get(user));
                }
            }
        }
    }

    //??应该是发送到远程的客户端
    //getAsyncRemote()和getBasicRemote()确实是异步与同步的区别
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //异步
        //this.session.getAsyncRemote().sendText(message);
    }

    //对所有用户发送消息
    public void broadcastMsg(String msg) {
        for (WebSocketLink item : webSocketSet) {//对应每一个Session
            try {
                item.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    //对单一用户发送消息
    public void singleMsg(String msg, Session session) {
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param message 交互信息
     * @param type    类型
     * @param list
     * @return 在线
     */
    //返回给前台的消息
    public String toChatweb(String message, String type, List list) {
        JSONObject allMsg = new JSONObject();
        allMsg.put("message", message);
        allMsg.put("type", type);
        allMsg.put("list", list);
        return allMsg.toString();
    }

    //getAsyncRemote()和getBasicRemote()确实是异步与同步的区别，大部分情况下，推荐使用getAsyncRemote()。

    public static int getOnlineCount() {
        return onlineCount;
    }

    public static void addOnlineCount() {
        WebSocketLink.onlineCount++;
    }

    public static void subOnlineCount() {
        WebSocketLink.onlineCount--;
    }
}
