<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<header class="header--form-page">
    <%@include file="../navbar.jsp" %>
    <h2>Szczegóły kategorii</h2>
    <div style="width: 50%; margin: 0 auto">
        <form:form class="form--contact" modelAttribute="category" method="post">

            <form:input type="hidden" path="id"/>

            <div class="form-group form-group--50">
                <form:input type="text" path="name" placeholder="Nazwa kategorii"/>
            </div>

            <button class="btn" type="submit">Zapisz</button>
        </form:form></div>
</header>

<%@ include file="../footer.jsp" %>