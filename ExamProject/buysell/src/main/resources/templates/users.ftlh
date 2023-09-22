<#import "blocks/template.ftlh" as c>
<@c.page>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Email</th>
            <th scope="col">ФИО</th>
            <th scope="col">Номер телефона</th>
            <th scope="col">Город</th>
            <th scope="col">Активный</th>
            <th scope="col">Роли</th>
            <th scope="col">Изменить данные</th>
            <th scope="col">Заблокировать</th>
            <th scope="col">Удалить</th>
        </tr>
        <#list users as user>
            <tr>
                <th>${user.email}</th>
                <th>${user.fullname}</th>
                <th>${user.phoneNumber}</th>
                <th>${user.city}</th>
                <th><#if user.active>true<#else>false</#if></th>
                <th><#list user.roles as role>${role}</#list></th>
                <th>
                    <div class="edit">
                        <a href="/admin/users/edit/${user.id}">Изменить данные</a>
                    </div>
                </th>
                <th>
                    <form action="/admin/users/ban/${user.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" class="btn btn-light" value="Заблокировать">
                    </form>
                </th>
                <th>
                    <form action="/admin/users/delete/${user.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Пользователей нет</h3>
        </#list>
    </table>
    <div class="homePage">
        <a href="/">На главную страницу</a>
    </div>
</@c.page>