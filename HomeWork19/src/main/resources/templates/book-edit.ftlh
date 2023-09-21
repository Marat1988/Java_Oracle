<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style.css">
    <title>Изменение данных книги</title>
</head>
<body>
<#if book??>
    <form action="/book/save" method="post" class="form-example">
        <div class="form-example">
            <label for="name">Введите название книги: </label>
            <input type="text" name="name" id="name" required value="${book.name}"/>
        </div>
        <div class="form-example">
            <label for="author">Введите автора: </label>
            <input type="text" name="author" id="author" required value="${book.author}"/>
        </div>
        <div class="form-example">
            <label for="year">Введите год выпуска: </label>
            <input  type="number" name="year" id="year" required  value="#{book.year}">
        </div>
        <div class="form-example">
            <label for="style">Введите стиль: </label>
            <input  type="text" name="style" id="style" required value="${book.style}"/>
        </div>
        <div class="form-example">
            <label for="pageCount">Введите количество страниц: </label>
            <input  type="number" name="pageCount" id="pageCount" required min="1" value="#{book.pageCount}"/>
        </div>
        <div class="form-example">
            <label for="description">Введите описание книги: </label>
            <input  type="text" name="description" id="description" required value="${book.description}"/>
        </div>
        <div class="form-example">
            <input type="submit" value="Сохранить изменения!" />
        </div>
        <input type="hidden" name="id" value="#{book.id}" />
    </form>
<#else>
    <h4>Книга не найдена</h4>
</#if>
<a href="/">Вернуться на гравную страницу</a>
</body>
</html>