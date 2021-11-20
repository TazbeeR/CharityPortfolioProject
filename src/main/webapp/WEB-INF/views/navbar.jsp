<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Podziel się tym co masz</title>
    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>" type="text/css"/>
</head>
<body>
<header>
    <nav class="container container--70">
        <sec:authorize access="!isAuthenticated()">
            <ul class="nav--actions">
                <li><a href="/login">Zaloguj</a></li>
                <li class="highlighted"><a href="/register">Załóż konto</a></li>
            </ul>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <ul class="nav--actions">
                <li>Witaj: <a href="/userinfo">${pageContext.request.userPrincipal.name}</a></li>
                <form action="<c:url value="/logout"/>" method="post">
                    <li class="highlighted">
                        <input type="submit" value="Wyloguj">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </li>
                </form>
            </ul>
        </sec:authorize>
        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>