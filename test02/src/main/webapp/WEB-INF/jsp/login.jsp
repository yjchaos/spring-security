<%--
  Created by IntelliJ IDEA.
  User: yaojun
  Date: 2019-05-09
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登陆页面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
    <h3>登陆页面</h3>
    <c:if test="${not empty param.error}">
        <span style="color: red; ">用户名或密码错误</span>
    </c:if>

    <form id="loginForm" action="${pageContext.request.contextPath}/securityLogin" method="post">
        <label>
            用户名：<input type="text" name="username">
        </label><br>
        <label>
            密码：<input type="text" name="password">
        </label><br>
        <label>
            验证码：<input type="text" name="imageCode">
            <img src="${pageContext.request.contextPath}/imageCode" alt="验证码"/>
        </label><br>
        <label>
            记住我：<input type="checkbox" name="remember-me" value="true">
        </label><br>
        <label>
            <input type="button" id="loginBtn" value="登陆">
        </label>
    </form>
    <script type="text/javascript">
        $(function () {
            $("#loginBtn").click(function () {
                $.post("${pageContext.request.contextPath}/securityLogin",$("#loginForm").serialize(),function (data) {
                    if (data.success) {
                        window.location.href="${pageContext.request.contextPath}/product/index";
                    }else{
                        alert("登陆失败:" + data.errorMsg);
                    }
                },"json");
            });
        })
    </script>

</body>
</html>
