<%@ page import="ru.babudzhi.model.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        .text {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="text">
<h1>Жители домов:</h1>
</div>
<table>
    <tbody>
    <c:forEach items="${listPersonsWithHome}" var="personDTO">
        <c:out value="${personDTO.person.lastName}"/>
        <c:out value="${personDTO.person.firstName}"/>
        <c:out value="${personDTO.person.middleName}"/> :

        <c:forEach items="${personDTO.person.home}" var="home">
                Ул. <c:out value="${home.street}"/>
             д.<c:out value="${home.number}"/>

        </c:forEach><p>

    </c:forEach></p>
    </tbody>
</table>

</body>
</html>
