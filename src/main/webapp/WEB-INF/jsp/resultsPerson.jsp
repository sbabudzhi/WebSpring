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
    <c:forEach items="${listPerson}" var="test" >
            <c:out value="${test.lastName}"/>
            <c:out value="${test.firstName}"/>
            <c:out value="${test.middleName}"/>

        <form action="remove" method="post">
            <input type="hidden" name = "idPerson" value="${test.id}">
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
    </tbody>
</table>
</body>
</html>
