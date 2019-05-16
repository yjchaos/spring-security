<%--
  Created by IntelliJ IDEA.
  User: yaojun
  Date: 2019-05-08
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<head>
    <title>首页</title>
</head>
<body>
欢迎用户：${username}<br>
以下是网站功能：<br>
<security:authorize access="hasAuthority('ROLE_ADD_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/add">商品添加</a><br>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_UPDATE_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/update">商品修改</a><br>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_LIST_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/list">商品查询</a><br>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_DELETE_PRODUCT')">
    <a href="${pageContext.request.contextPath}/product/delete">商品删除</a><br>
</security:authorize>
</body>
</html>
