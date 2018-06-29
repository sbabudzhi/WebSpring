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
    <form action="addUserInHome" method="post"><p></p>
        <c:forEach items="${listPersons}" var="person" >
            <c:out value="${person.lastName}"/>
            <c:out value="${person.firstName}"/>
            <c:out value="${person.middleName}"/>

                <c:forEach items="${listHomes}" var="home">
                    <input type="checkbox" name="home" value="${person.id}_${home.id}">Ул. "${home.street}"  д."${home.number}"
                </c:forEach> <Br> <br>
        </c:forEach> <br>
            <input type="submit" name="addUserInHome" value="Отправить">
    </form>
   <p>
    Вернуться к вводу домов
        <form action="homeEnter" method="post">
            <input type="submit" value="Ввести адрес дома">
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
