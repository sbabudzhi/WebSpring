<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Results of Data Base</title>
</head>
<body>
<b>Список введеных человек:</b>
<table>
    <tbody>
    <c:forEach items="${list}" var="test">
        <p>
            <c:out value="${test}"/>
        </p>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
