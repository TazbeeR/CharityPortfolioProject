<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<nav class="container container--70">
    <sec:authorize access="!isAuthenticated()">
        <ul class="nav--actions">
            <li><a href="/login">Zaloguj</a></li>
            <li class="highlighted"><a href="/register">Załóż konto</a></li>
        </ul>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj ${pageContext.request.userPrincipal.name}
                <ul class="dropdown">
                    <li><a href="/userinfo">Profil</a></li>

                    <li><a href="#">Moje zbiórki</a></li>
                    <li><a href="/logout">Wyloguj</a></li>
                </ul>
            </li>
        </ul>
    </sec:authorize>
    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="/#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul><br />
    <sec:authorize access="hasRole('ADMIN')">
            <ul>
                <li><a class="btn btn--without-border">Panel administratora</a></li>
                <li><a href="/admin/message/all" class="btn btn--without-border">Wiadomości</a></li>
                <li><a href="/admin/institution/all" class="btn btn--without-border">Instytucje</a></li>
                <li><a href="/admin/donation/all" class="btn btn--without-border">Donacje</a></li>
                <li><a href="/admin/user/all" class="btn btn--without-border">Użytkownicy</a></li>
                <li><a href="/admin/category/all" class="btn btn--without-border">Kategorie</a></li>
            </ul>
    </sec:authorize>
</nav>