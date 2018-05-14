<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/5/14
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%String path = request.getContextPath();%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=path%>/file/uploadAfter" method="post" enctype="multipart/form-data">
    <input type="file" name="file" value="请选择上传的文件">
    <input type="submit" value="提交">
</form>
</body>
</html>
