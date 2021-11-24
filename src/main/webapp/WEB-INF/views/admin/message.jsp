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
    <h2>Wiadomości</h2>
    <div>
        <table class="tableAdmin">
            <thead>
            <tr>
                <th style="width: 5%">Id</th>
                <th style="width: 10%">Imię</th>
                <th style="width: 18%">Email</th>
                <th>Wiadomość</th>
                <th style="width: 220px">Akcje</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <td colspan="5">
                    <div class="links">W trakcie prac <a href="#">&laquo;</a> <a class="active" href="#">1</a> <a href="#">2</a> <a
                            href="#">3</a> <a href="#">4</a> <a href="#">&raquo;</a></div>
                </td>
            </tr>
            </tfoot>
            <tbody>
            <c:forEach items="${messages}" var="message">
                <tr>
                    <td>${message.id}</td>
                    <td>${message.name}</td>
<%--                    <c:if test=""--%>
                    <td>${message.email}</td>

                    <td><a href="/admin/message/read/${message.id}">${message.message}</a></td>
                    <td>
<%--                       <button class="btn-gray" onclick="document.location='/admin/message/read/${message.id}'">Czytaj</button> &nbsp;--%>
                       <button class="btn-gray" onclick="document.location='/admin/message/delete/${message.id}'">Usuń</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</header>

<%@include file="../footer.jsp" %>