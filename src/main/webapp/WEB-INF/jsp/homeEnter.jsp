<%@page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ввод данных</title>
    <style>
        .text {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="text">
    <h1>Введите название улицы и номер дома:</h1>
    <form method="post"  action="addHome" accept-charset="UTF-8">
        <p> <input type="text" name="street" onkeydown="if(event.keyCode==13){return false;}">
            <input type="text" name="number" onkeydown="if(event.keyCode==13){return false;}">
            <input type="submit" name="enter" value="Отправить">
    </form>

    <form method="post" action="userInHome">
        <p> <input type="submit" name="addUser" value="Добавить жителя в дом" ></p>
    </form>
    <form method="post" action="userEnter" >
        <p><input type="submit" name="enterUser" value="Ввести ФИО пользователя"></p>
    </form>
</div>
</body>
</html>
