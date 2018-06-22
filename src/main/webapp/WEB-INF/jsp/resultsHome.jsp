<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Results of Data Base</title>
</head>
<body>
<b>Список домов:</b>
<table>
<tbody>

<c:forEach items="${listHomes}" var="home">
    <c:out value="${home.street}"/>
    <c:out value="${home.number}"/>
</c:forEach>
Вернуться к вводу
<form action="homeEnter" method="post">
    <input type="submit" name= "back" value="Назад">
</form>


    </tbody>
    </table>
    </body>
    </html>
