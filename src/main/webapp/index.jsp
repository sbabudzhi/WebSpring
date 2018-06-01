<%@ page contentType="text/html;charset=utf-8" %>
<%
    String userId = "";
    boolean dropTable = false;

    if(session.isNew()) {
        dropTable = true;
        userId = session.getId();
    }
    session.setAttribute("dropTable", dropTable);
    session.setAttribute("userId", userId);
    session.setAttribute("sesId", session.getId());
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добро пожаловать!</title>
    <style>
        .text {
            text-align: center;
        }
    </style>
</head>
<body >
<div class="text">
    <h1>Введите Ваши ФИО:</h1>
    <form method="post"  action="bd" accept-charset="UTF-8">
        <p> <input type="text" name="lastName" onkeydown="if(event.keyCode==13){return false;}">
            <input type="text" name="firstName" onkeydown="if(event.keyCode==13){return false;}">
            <input type="text" name="middleName" onkeydown="if(event.keyCode==13){return false;}"> </p>
        <input type="submit" name="enter">
    </form>
</div>

<form method="get" action="bd">
    <p> <input type="submit" name="res" value="Результат" ></p>
</form>
</body>
</html>
