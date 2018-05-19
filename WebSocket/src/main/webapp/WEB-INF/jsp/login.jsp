<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/5/18
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String path = request.getContextPath();%>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="<%=path%>/successLogin">
    <input type="text" name="userId" id="userId" placeholder="账号">
    <input type="password" name="userPws" id="userPws" placeholder="密码">
    <input type="submit" value="提交">
</form>
</body>
</html>
