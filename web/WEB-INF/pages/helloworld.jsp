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
        <h1>Добро пожаловать пользователь: <br> <sec:authentication property="principal.username" /></h1>
    </div>
</section>
</body>
</html>
</body>
</html>
