<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/5/17
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>chat</title>
</head>
<body>

<input type="text" id="text">
<button id="btnSend" onclick="send()">发送</button>
<button id="btnClose" onclick="closeWebSocket()">关闭</button>
<div>
    <div>
        <h5>在线列表</h5>
    </div>
    <div>
        <ul id="list"></ul>
    </div>
</div>
<textarea id="txt_chat" cols="30" rows="10"></textarea>
<table id="table"></table>
</body>

<script type="text/javascript">
    var websocket = null;
    //注意单词的拼写
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/websocket");
    }
    else {
        alert("当前浏览器不支持websocket")
    }

    websocket.onerror = function () {
        //setMSGInHtml("连接时发生错误");
        alert("连接发生错误")
    };

    websocket.onopen = function () {
        //setMSGInHtml("连接成功");
        alert("连接成功")
    };
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMSGInHtml(event.data);
    }

    function send() {
        var message = document.getElementById('text').value;
        //向服务器发送消息
        //websocket.send(message);
        websocket.send(JSON.stringify({
            message: {
                content: message,
                from: '${userId}',
                to: "123,12",
            },
            type: "message"
        }));
    }

    websocket.onclose = function () {
        // setMSGInHtml("连接已经关闭")
        alert("连接已经关闭")
    }

    //连接关闭的回调方法
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //close
    function closeWebSocket() {
        websocket.close();
    }

    function setMSGInHtml(toHtml) {
        //JSON字符串转化为对象
        var message = JSON.parse(toHtml);
        //第一个message是JSON对象，第二个是JSON里面的message，不然接收不到
        document.getElementById('txt_chat').innerHTML += message.message.content + " ";
    }
</script>
</html>
