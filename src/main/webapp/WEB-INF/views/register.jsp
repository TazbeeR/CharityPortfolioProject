<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Podziel się tym co masz</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" type="text/css"/>
</head>
<body>
<header>
<%@include file="navbar.jsp" %>
</header>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" modelAttribute="user">
        <div class="form-group">
            <form:input type="email" path="username" placeholder="Email"/><br />
            <form:errors path="username" cssStyle="color: red; font-size: medium"/>
        </div>
        <div class="form-group">
            <form:input type="password" path="password" placeholder="Hasło"/><br />
            <form:errors path="password" cssStyle="color: red; font-size: medium"/>
        </div>
        <div class="form-group">
            <form:input type="password" path="password2" placeholder="Powtórz hasło"/><br />
            <span style="color: red; font-size: medium">${dontMatch}</span>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@include file="footer.jsp" %>