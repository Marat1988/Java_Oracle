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
        <#list lenvators as lenvator>
            <tr>
                <th>${lenvator.id}</th>
                <th>${lenvator.fullname}</th>
                <th>${lenvator.telephone}</th>
                <th>
                    <div class="edit">
                        <a href="/lenvator/edit/${lenvator.id}">Редактировать</a>
                    </div>
                </th>
                <th>
                    <form action="/lenvator/delete/${lenvator.id}" method="post">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Арентодателей в базе нет</h3>
        </#list>
    </table>
    <div>
        <div class="add">
            <a href="/lenvator/insert">Добавить арентодателя</a>
        </div>
        <div class="homePage">
            <a href="/">На главную страницу</a>
        </div>
    </div>
</@c.page>