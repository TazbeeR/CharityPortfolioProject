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
        <h2>Instytucje</h2>

    <div>
        <center>
        <button class="btn-gray" onclick="document.location='/admin/institution/add'">Dodaj</button>
        </center><br />
        <table class="tableAdmin">
                <thead>
                <tr>
                    <th style="width: 75px">Id</th>
                    <th style="width: 25%">Nazwa Fundacji</th>
                    <th style="width: 50%">Opis</th>
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
                <c:forEach items="${institutions}" var="institution">
                    <tr>
                        <td>${institution.id}</td>
                        <td>${institution.name}</td>
                        <td>${institution.description}</td>
                        <td>
                            <button class="btn-gray" onclick="document.location='/admin/institution/delete/${institution.id}'">Usuń</button>
                            <button class="btn-gray" onclick="document.location='/admin/institution/update/${institution.id}'">Edytuj</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</header>

<%@include file="../footer.jsp"%>