<#import "blocks/template.ftlh" as c>
<@c.page>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Дата начала аренды</th>
            <th scope="col">Адрес квартиры</th>
            <th scope="col">ФИО арендателя</th>
            <th scope="col">ФИО арентодатора</th>
            <th scope="col">Изменить</th>
            <th scope="col">Удалить</th>
        </tr>
        <#list rents as rent>
            <tr>
                <th>${rent.id}</th>
                <th>${rent.dateTimeRent}</th>
                <th>${rent.apartment.address}</th>
                <th>${rent.apartment.lenvator.fullname}</th>
                <th>${rent.renter.fullname}</th>
                <th>
                    <div class="edit">
                        <a href="/rent/edit/${rent.id}">Редактировать</a>
                    </div>
                </th>
                <th>
                    <form action="/rent/delete/${rent.id}" method="post">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Аренды квартир в базе отсутствуют</h3>
        </#list>
    </table>
    <div>
        <div class="add">
            <a href="/rent/insert">Добавить аренду квартиры</a>
        </div>
        <div class="homePage">
            <a href="/">На главную страницу</a>
        </div>
    </div>
</@c.page>