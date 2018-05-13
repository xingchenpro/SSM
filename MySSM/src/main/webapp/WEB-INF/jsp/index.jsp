<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%String path = request.getContextPath();%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center" style="text-align: center">
    <tr>
        <td>值</td>
        <td>标签</td>
    </tr>
    <tr>
        <td>账号</td>
        <td><c:out value="${user.userId}"></c:out></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><c:out value="${user.userPassword}"></c:out></td>
    </tr>
    <tr>
        <td>昵称</td>
        <td><c:out value="${user.userNickName}"></c:out></td>
    </tr>

</table>
</body>
</html>
