<%--
  Created by IntelliJ IDEA.
  User: yaojun
  Date: 2019-05-08
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品的添加页面</title>
</head>
<body>
这是商品的添加页面
<form action="${pageContext.request.contextPath}/product/add" method="post">
    <label>
        <input type="text" name="product_name">
    </label>
    <label>
        <input type="text" name="product_price">
    </label>
    <label>
        <input type="submit" value="提交">
    </label>
</form>
</body>
</html>
