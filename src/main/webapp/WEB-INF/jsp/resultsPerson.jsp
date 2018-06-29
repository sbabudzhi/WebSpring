<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Results of Data Base</title>
</head>
<body>
<b>Список введеных человек:</b>
<table>
    <tbody>
<p></p>
    <c:forEach items="${listPersons}" var="person" >
        <c:out value="${person.lastName}"/>
        <c:out value="${person.firstName}"/>
        <c:out value="${person.middleName}"/>:

        <c:set var="homeExist" value="${person.homeDTO.size()}"/>
        <c:if test="${homeExist == 0}">
            Дома не найдены
        </c:if>
        <c:if test="${homeExist != 0}">
            <c:forEach items="${person.homeDTO}" var="home">
                Ул. <c:out value="${home.street}"/>
                д.<c:out value="${home.number}"/>
            </c:forEach>
        </c:if>

        <form action="remove" method="post">
            <input type="hidden" name = "idPerson" value="${person.id}">
            <input type="submit" name= "deleteButton" value="Удалить строку">
        </form>
        <Br>
        <Br>
    </c:forEach>
<p>Вернуться к вводу
    <form action="userEnter" method="post">
        <input type="submit" name= "back" value="Назад">
    </form>
</p>
<p>Посмотреть в JSON
<form action="/getPersonWithHome" method="post">
    <input type="submit" name= "show" value="Посмотреть">
</form>
</p>
    </tbody>
</table>
</body>
</html>
