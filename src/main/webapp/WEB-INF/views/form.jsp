<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>

<h1 align="center">widok formularza</h1>

<form:form method="post" modelAttribute="donation">
<form:checkboxes path="categories"
                 items="${categories}"/>
<form:select path="institution" items="${institutions}"/>
    zip code
<form:input path="zipCode" />
    ulica
<form:input path="street" />
    miasto
<form:input path="city"/>
    ilosc
<form:input path="quantity"/>
    komentarz
<form:textarea path="pickUpComment"/>
<form:input type="date" path="pickUpDate"/>
<form:input type="time" path="pickUpTime" />
<input type="submit">
</form:form>
<%@include file="footer.jsp"%>