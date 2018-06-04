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
    <link href="../../static/css/chat.css" rel="stylesheet" type="text/css">

</head>
<body>

<%--<input type="text" id="text">
<button id="btnSend" onclick="send()">发送</button>
<button id="btnClose" onclick="closeWebSocket()">关闭</button>
<div>

    <div>
        <ul id="list"></ul>
    </div>
</div>
<textarea id="txt_chat" cols="30" rows="10"></textarea>
<table id="table"></table>--%>

<div class="all">
    <div class="chat_index">
        <!--banner-->
        <div class="chat_banner">

        </div>

        <div class="chat_body">
            <!--在线列表-->
            <div class="chat_online">
                <!--搜索-->
                <div class="search_online">
                    <form>
                        <input type="text" placeholder="搜索联系人">
                    </form>
                </div>
                <div class="online_friend">
                    <ul>
                        <li>
                            <div class="a_friend">
                                <div class="head_portrait">
                                    <div class="head_text">
                                        黄
                                    </div>
                                </div>
                                <div class="friend">

                                    <div class="name">天狼星</div>
                                    <div class="this_time">4-12-15:10</div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="a_friend">
                                <div class="head_portrait">
                                    <div class="head_text">
                                        黄
                                    </div>
                                </div>
                                <div class="friend">

                                    <div class="name">天狼星</div>
                                    <div class="this_time">4-12-15:10</div>

                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="a_friend">
                                <div class="head_portrait">
                                    <div class="head_text">
                                        黄
                                    </div>
                                </div>
                                <div class="friend">

                                    <div class="name">天狼星</div>
                                    <div class="this_time">4-12-15:10</div>

                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="a_friend">
                                <div class="head_portrait">
                                    <div class="head_text">
                                        黄
                                    </div>
                                </div>
                                <div class="friend">

                                    <div class="name">天狼星</div>
                                    <div class="this_time">4-12-15:10</div>

                                </div>
                            </div>
                        </li>
                    </ul>
                </div>

            </div>
            <!--聊天界面-->
            <div class="chat_main">
                <div class="chat_div">
                    <ul id="chat_ul" class="chat_content">

                    </ul>

                </div>

                <div class="send_message">
                    <form>
                        <input type="text" placeholder="请输入消息" id="send_txt">
                        <input type="button" value="发送" id="send_btn" onclick="send()">
                    </form>
                </div>
            </div>
            <!--名片-->
            <div class="chat_namecard">

            </div>
        </div>

    </div>
</div>
<script type="text/javascript">
    //设置js的全局变量，js的全局变量在整个生命周期中存在
    l_name = ${userId};
</script>
<script type="text/javascript" src="../../static/js/chat.js"></script>
</body>

</html>
