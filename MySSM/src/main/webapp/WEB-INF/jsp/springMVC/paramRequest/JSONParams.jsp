<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/12
  Time: 21:09
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();%>

<html>
<head>
    <title>Title</title>
    <script src="<%=path%>/static/source/js/jquery-2.1.4.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#start").click(function () {
                alert("点击了");
                var user={
                        userId: "e",
                        userNickName: "hly",
                        userPassword: "qq",

                    }
                $.ajax({
                    url:"<%=path%>/jsonParam/jsonParam/",
                    type : "POST",
                    data:JSON.stringify(user),
                    contentType:'application/json',
                    dataType : 'json',
                    beforeSend : function () {
                        console.log(user);
                    },
                    success:function () {
                        alert("传递成功");
                    },
                    error:function () {
                        alert("错误了");
                    }
                });
            });
        });
    </script>
</head>
<body>

<input type="button" value="start" id="start">

</body>


</html>
