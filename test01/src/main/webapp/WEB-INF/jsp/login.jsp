<%--
  Created by IntelliJ IDEA.
  User: yaojun
  Date: 2019-05-09
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
    <h3>登陆页面</h3>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>
            用户名：<input type="text" name="username">
        </label><br>
        <label>
            密码：<input type="text" name="password">
        </label><br>
        <label>
            <input type="submit" value="提交">
        </label>
    </form>
</body>
</html>
