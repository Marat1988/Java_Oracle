<#import "blocks/template.ftlh" as c>
<@c.page>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Адрес</th>
            <th scope="col">Количество комнат</th>
            <th scope="col">Цена (за месяц)</th>
            <th scope="col">Арентодатель</th>
            <th scope="col">Изменить</th>
            <th scope="col">Удалить</th>
        </tr>
        <#list apartments as apartment>
            <tr>
                <th>${apartment.id}</th>
                <th>${apartment.address}</th>
                <th>${apartment.roomCount}</th>
                <th>${apartment.price}</th>
                <th>${apartment.lenvator.getFullname()}</th>

                <th>
                    <div class="edit">
                        <a href="/apartment/edit/${apartment.id}">Редактировать</a>
                    </div>
                </th>
                <th>
                    <form action="/apartment/delete/${apartment.id}" method="post">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Квартир в базе нет</h3>
        </#list>
    </table>
    <div>
        <div class="add">
            <a href="/apartment/insert">Добавить квартиру</a>
        </div>
        <div class="homePage">
            <a href="/">На главную страницу</a>
        </div>
    </div>
</@c.page>