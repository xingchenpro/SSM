<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/5/14
  Time: 14:16
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
<%--<%
   session.setAttribute("id",1);
   response.sendRedirect("./attribute/RequestAttribute");
%>--%>
<%
    request.setAttribute("id",1);
    request.getRequestDispatcher("./attribute/RequestAttribute").forward(request,response);
%>
</body>
</html>
