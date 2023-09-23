<#import "blocks/template.ftlh" as c>
<@c.page>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">ФИО</th>
            <th scope="col">Номер телефона</th>
            <th scope="col">Изменить</th>
            <th scope="col">Удалить</th>
        </tr>
        <#list renters as renter>
            <tr>
                <th>${renter.id}</th>
                <th>${renter.fullname}</th>
                <th>${renter.telephone}</th>
                <th>
                    <div class="edit">
                        <a href="/renter/edit/${renter.id}">Редактировать</a>
                    </div>
                </th>
                <th>
                    <form action="/renter/delete/${renter.id}" method="post">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Арендаторов в базе нет</h3>
        </#list>
    </table>
    <div>
        <div class="add">
            <a href="/renter/insert">Добавить арендатора</a>
        </div>
        <div class="homePage">
            <a href="/">На главную страницу</a>
        </div>
    </div>
</@c.page>