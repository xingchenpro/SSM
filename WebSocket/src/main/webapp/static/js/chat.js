
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

    //传输数据到服务器
    var message = document.getElementById('send_txt').value;
    //alert(message)
    //向服务器发送消息
    //websocket.send(message);
    websocket.send(JSON.stringify({
        message: {
            content: message,
            from: l_name,
            to: "",
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

//需要定义成全局才有效
var now = -1;//左右浮动
var num ;//判断左右
function setMSGInHtml(toHtml) {
    var send_btn = document.getElementById('send_btn');
    var send_txt = document.getElementById('send_txt');
    var chat_ul = document.getElementById('chat_ul');
    var chat_span = chat_ul.getElementsByTagName('span');
    var chat_img = chat_ul.getElementsByTagName('img');
    //JSON字符串转化为对象
    var message = JSON.parse(toHtml);
    //alert(message.message.from)
    if(l_name==message.message.from)
        //若果是自己则在右边
         num = 0;
    else
        num=1
    //第一个message是JSON对象，第二个是JSON里面的message，不然接收不到
    // document.getElementById('send_txt').innerHTML += message.message.content + " ";

    /*if (send_txt.value == '') {
        alert("请不要惜字如金");
    } else {*/
    chat_ul.innerHTML += '<li><img src="../../static/img/img_26.jpg"><span>' + message.message.content + '</span>';
    now++;
    if (num == 0) {
        chat_span[now].className = 'spanright';
        chat_img[now].className = 'imgright';

    }
    else {
        chat_span[now].className = 'spanleft';
        chat_img[now].className = 'imgleft';
        // }

        // 内容过多时,将滚动条放置到最底端
        /*contentcontent.scrollTop = content.scrollHeight;*/
    }

    send_txt.value = '';
}



