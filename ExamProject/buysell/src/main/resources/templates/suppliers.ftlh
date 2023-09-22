<#import "blocks/template.ftlh" as c>
<@c.page>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Наименование поставщика</th>
            <th scope="col">Изменить данные</th>
            <th scope="col">Удалить</th>
        </tr>
        <#list suppliers as supplier>
            <tr>
                <th>${supplier.name}</th>
                <th>
                    <div class="edit">
                        <a href="/admin/suppliers/edit/${supplier.id}">Редактировать</a>
                    </div>
                </th>
                <th>
                    <form action="/admin/suppliers/delete/${supplier.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Поставщиков нет</h3>
        </#list>
    </table>
    <div class="add">
        <a href="/admin/suppliers/insert">Добавить нового поставщика</a>
    </div>
    <div class="homePage">
        <a href="/">На главную страницу</a>
    </div>
</@c.page>