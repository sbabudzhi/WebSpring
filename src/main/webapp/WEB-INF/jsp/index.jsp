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
    <h1>Введите Ваши ФИО:</h1>
    <form method="post"  action="add" accept-charset="UTF-8">
        <p> <input type="text" name="lastName" onkeydown="if(event.keyCode==13){return false;}">
            <input type="text" name="firstName" onkeydown="if(event.keyCode==13){return false;}">
            <input type="text" name="middleName" onkeydown="if(event.keyCode==13){return false;}"> </p>
            <input type="submit" name="enter" value="Отправить">
    </form>

    <form method="post" action="persons">
    <p> <input type="submit" name="res" value="Результат" ></p>
    </form>
</div>
</body>
</html>
