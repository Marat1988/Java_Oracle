<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/style.css">
    <title>Книги</title>
</head>
<body>
<h1>Информация по книгам</h1>
<div id="resp-table">
    <div id="resp-table-body">
        <div class="resp-table-row header">
            <div class="table-body-cell">
                Название книги
            </div>
            <div class="table-body-cell">
                ФИО автора
            </div>
            <div class="table-body-cell">
                Год выпуска
            </div>
            <div class="table-body-cell">
                Стиль книги
            </div>
            <div class="table-body-cell">
                Количество страниц
            </div>
            <div class="table-body-cell">
                Краткое описание книги
            </div>
            <div class="table-body-cell">
                Изменение
            </div>
            <div class="table-body-cell">
                Удаление
            </div>
        </div>
        <#list listBook as book>
            <div class="resp-table-row">
                <div class="table-body-cell">
                    ${book.name}
                </div>
                <div class="table-body-cell">
                    ${book.author}
                </div>
                <div class="table-body-cell">
                    ${book.year}
                </div>
                <div class="table-body-cell">
                    ${book.style}
                </div>
                <div class="table-body-cell">
                    ${book.pageCount}
                </div>
                <div class="table-body-cell">
                    ${book.description}
                </div>
                <div class="table-body-cell">
                    <a href="/book/edit/${book.id}">Изменить данные книги</a>
                </div>
                <div class="table-body-cell">
                    <form action="/book/delete/${book.id}" method="post">
                        <input type="submit" value="Удалить">
                    </form>
                </div>
            </div>
        <#else>
            <h4>Книг нет</h4>
        </#list>
    </div>
</div>
<h2>Добавление новой книги</h2>
<form action="/book/save" method="post" class="form-example">
    <div class="form-example">
        <label for="name">Введите название книги: </label>
        <input type="text" name="name" id="name" required/>
    </div>
    <div class="form-example">
        <label for="author">Введите автора: </label>
        <input type="text" name="author" id="author" required/>
    </div>
    <div class="form-example">
        <label for="year">Введите год выпуска: </label>
        <input type="number" name="year" id="year" required>
    </div>
    <div class="form-example">
        <label for="style">Введите стиль: </label>
        <input type="text" name="style" id="style" required/>
    </div>
    <div class="form-example">
        <label for="pageCount">Введите количество страниц: </label>
        <input type="number" name="pageCount" id="pageCount" required min="1"/>
    </div>
    <div class="form-example">
        <label for="description">Введите описание книги: </label>
        <input type="text" name="description" id="description" required/>
    </div>
    <div class="form-example">
        <input type="submit" value="Добавить новую книгу"/>
    </div>
</form>
<div>
    <div class="search">
        <h2>Поиск по названию книги</h2>
        <form action="/findName" method="get" class="form-example">
            <div class="form-example">
                <label for="name">Введите название книги: </label>
                <input type="text" name="name" id="name" required/>
            </div>
            <div class="form-example">
                <input type="submit" value="Поиск"/>
            </div>
        </form>
    </div>

    <div class="search">
        <h2>Поиск по автору</h2>
        <form action="/findAuthor" method="get" class="form-example">
            <div class="form-example">
                <label for="author">Введите автора книги: </label>
                <input type="text" name="author" id="author" required/>
            </div>
            <div class="form-example">
                <input type="submit" value="Поиск"/>
            </div>
        </form>
    </div>

    <div class="search">
        <h2>Поиск по году выпуска</h2>
        <form action="/findYear" method="get" class="form-example">
            <div class="form-example">
                <label for="year">Введите год: </label>
                <input type="number" name="year" id="year" required/>
            </div>
            <div class="form-example">
                <input type="submit" value="Поиск"/>
            </div>
        </form>
    </div>

    <div class="search">
        <h2>Поиск по стилю</h2>
        <form action="/findStyle" method="get" class="form-example">
            <div class="form-example">
                <label for="style">Введите стиль: </label>
                <input type="text" name="style" id="style" required/>
            </div>
            <div class="form-example">
                <input type="submit" value="Поиск"/>
            </div>
        </form>
    </div>

    <div class="search">
        <h2>Поиск по количеству страниц</h2>
        <form action="/findPageCount" method="get" class="form-example">
            <div class="form-example">
                <label for="pageCount">Введите стиль: </label>
                <input type="number" name="pageCount" id="pageCount" required/>
            </div>
            <div class="form-example">
                <input type="submit" value="Поиск"/>
            </div>
        </form>
    </div>

    <div class="search">
        <h2>Поиск по слову для поиска в кратком описании книги</h2>
        <form action="/findDescriptionIsLike" method="get" class="form-example">
            <div class="form-example">
                <label for="word">Введите слово для поиска: </label>
                <input type="text" name="word" id="word" required/>
            </div>
            <div class="form-example">
                <input type="submit" value="Поиск"/>
            </div>
        </form>
    </div>


</div>






</body>
</html>