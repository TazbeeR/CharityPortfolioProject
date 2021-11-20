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
                        <sec:authorize access="hasRole('ADMIN')">
                        <li><a href="#">Panel administratora</a> </li>
                        </sec:authorize>
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
        </ul>
    </nav>