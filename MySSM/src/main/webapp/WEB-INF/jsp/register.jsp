<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%String path = request.getContextPath();%>
<html>
<head>
    <title>Title</title>
    <script src="<%=path%>/static/source/js/jquery.min.js"></script>
    <link href="<%=path%>/static/source/css/test.css" rel="stylesheet">
    <script type="text/javascript">
    </script>
</head >
<body>
<form id="form" action="<%=path%>/user/FlashRir">
    <table>
        <tr>
            <td>账号</td>
            <td><input id="id" name="userId" value=""></td>
        </tr>
        <tr>
            <td>昵称</td>
            <td><input id="nickname" name="userNickName" value=""></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input id="ps" name="userPassword" value=""></td>
        </tr>
        <tr>
            <td></td>
            <td align="right"><input id="commit" type="submit" value="注册"></td>
        </tr>
    </table>
</form>

</body>
</html>
