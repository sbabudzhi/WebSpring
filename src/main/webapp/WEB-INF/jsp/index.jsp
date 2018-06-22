<%@page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добро пожаловать</title>
    <style>
        .text {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="text">
    <h1>Выберите желаемое действие</h1>
    <form method="post" action="userEnter" accept-charset="UTF-8">
        <p> <input type="submit" name="enterPerson" value="Ввести пользователя">
    </form>

    <form method="post" action="homeEnter" accept-charset="UTF-8">
        <p> <input type="submit" name="enterHome" value="Ввести дома" ></p>
    </form>
</div>
</body>
</html>

