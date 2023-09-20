<#import "blocks/template.ftlh" as c>
<@c.page>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Название группы</th>
            <th scope="col">Изменить данные</th>
            <th scope="col">Удалить</th>
        </tr>
        <#list groups as group>
            <tr>
                <th>${group.name}</th>
                <th><a href="/admin/groups/edit/${group.id}">Изменить данные</a> </th>
                <th>
                    <form action="/admin/groups/delete/${group.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Групп товаров нет</h3>
        </#list>
    </table>
    <div>
        <a href="/admin/groups/insert" style="font-size: 18px; font-weight: bold;">Добавить новую группу</a>
    </div>
</@c.page>