<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.09.2018
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/pages/static/header.jsp" %>
</head>
<body>
<section class="container">
    <div class="login">
        <h1>Регистрация нового пользователя</h1>
        <form action="${pageContext.servletContext.contextPath}/reg" method="post">
            <p><input type="text" name="username" value="" placeholder="Логин"></p>
            <p><input type="password" name="password" value="" placeholder="Пароль"></p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <p class="submit"><input type="submit" name="commit" value="Регистрация" > </p>
        </form>
    </div>
    <div class="login-help">
        <p>${status}</p>
    </div>
</section>
</body>
</html>
