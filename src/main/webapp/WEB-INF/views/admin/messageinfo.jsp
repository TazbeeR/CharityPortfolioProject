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
<header class="header--form-page">
    <%@include file="../navbar.jsp" %>
    <h2>Wiadomość od ${message.name}</h2>

<h2 style="font-size: 25px">
    ${message.message}
        <br />
        <button class="btn-gray"><a href="mailto:${message.email}">Odpowiedz</a></button>
        <br />
        <button class="btn-gray" onclick="document.location='/admin/message/all'">Powrót</button>
</h2>
</header>

<%@include file="../footer.jsp" %>