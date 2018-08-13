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

            /*传递数组*/
            $("#list").click(function () {
                alert("点击了");
                var myList = [1, 2, 3];
                $.ajax({
                    url: "<%=path%>/listParam/listParam/",
                    type: "POST",
                    data: JSON.stringify([1, 2, 3]),
                    contentType: 'application/json',
                    dataType: 'json',
                    beforeSend: function () {
                        console.log(myList);
                    },
                    success: function () {
                        alert("传递成功");
                    },
                    error: function () {
                        alert("错误了");
                    }
                });
            });


            /*传递对象数组*/
            $("#userList").click(function () {
                alert("点击了");
                var usersList = [
                    {userId: "1", userNickName: "hly", userPassword: "123",},
                    {userId: "e", userNickName: "hly", userPassword: "qq",},
                    {userId: "e", userNickName: "hly", userPassword: "qq",}
                ];

                $.ajax({
                    url: "<%=path%>/listParam/userListParam/",
                    type: "POST",
                    data: JSON.stringify(usersList),
                    contentType: 'application/json',
                    dataType: 'json',
                });
            });

            /*传递序列化对象*/
            $("#submit").click(function () {
                var str = $("form").serialize();
                $.ajax({
                    url: "<%=path%>/listParam/formParam/",
                    type: "POST",
                    data: str,
                });
            });



        });
    </script>
</head>
<body>
l
    <input type="button" value="list" id="list">
    <input type="button" value="userList" id="userList">
    <form id="form">
    <input type="text" name="userId">
    <input type="text" name="userPassword">
    <input type="submit" name="submit" id="submit">
    </form>


</body>


</html>
