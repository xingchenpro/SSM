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
</head>
<body>
<form action="<%=path%>/requestParam/requestParam">
    <input type="text" name="user_id">
    <input type="text" name="user_password">
    <input type="submit" value="提交">
</form>

</body>
</html>
