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
                <th>
                    <div class="edit">
                        <a href="/admin/groups/edit/${group.id}">Редактировать</a>
                    </div>
                </th>
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
        <div class="add">
            <a href="/admin/groups/insert">Добавить новую группу</a>
        </div>
        <div class="homePage">
            <a href="/">На главную страницу</a>
        </div>
    </div>


</@c.page>