<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Results of Data Base</title>
</head>
<body>
    <b>Выберите дома для каждого жителя.</b>
<table>
<p>
    <form action="addUserInHome" method="post"><p>
        <c:forEach items="${listPerson}" var="test" >
            <c:out value="${test.lastName}"/>
            <c:out value="${test.firstName}"/>
            <c:out value="${test.middleName}"/>
            <input type="hidden" name = "idPerson" value="${test.id}">
            <c:forEach items="${listHomes}" var="home">
                 <input type="hidden" name="idHome" value="${home.id}">
                <input type="checkbox" name="home" value="${home.id}">Ул. "${home.street}"  д."${home.number}"
            </c:forEach> <Br> <br>
        </c:forEach> <br>
            <input type="submit" name="addUserInHome" value="Отправить">
    </form>
   <p>
    Вернуться к вводу домов
        <form action="homeEnter" method="post">
            <input type="submit" value="Ввести дома">
        </form>
    </p>
    <p>
    Вывести результат
    <form action="results" method="post">
        <input type="submit" value="Результат">
    </form>
    </p>
</tbody>
</table>
</body>
</html>