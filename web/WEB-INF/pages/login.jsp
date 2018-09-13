<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/login" var="loginUrl"/>
<c:url value="/logout" var="logOut"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <%@include file="/WEB-INF/pages/static/header.jsp" %>
    </head>
<body>

<section class="container">
    <div class="login">
        <h1>Войти в личный кабинет</h1>
        <form action="${loginUrl}" method="post">
            <p><input type="text" name="username" value="" placeholder="Логин или Email"></p>
            <p><input type="password" name="password" value="" placeholder="Пароль"></p>
            <p class="remember_me">
                <label>
                    <input type="checkbox" name="remember_me" id="remember_me">
                    Запомнить меня
                </label>
            </p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <p class="submit"><input type="submit" name="commit" value="Войти" > </p>
        </form>
    </div>

    <div class="reg">
        <h1>Нет аккаунта? <a href="${pageContext.servletContext.contextPath}/reg">Регистрируйтесь</a></h1>
    </div>

    <div class="login-help">
        <c:if test="${param.error != null}">
            <p>Неправильный логин или пароль</p>
        </c:if>
    </div>
</section>
</body>
</html>