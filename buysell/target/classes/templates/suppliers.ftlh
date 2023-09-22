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
                <th><a href="/admin/suppliers/edit/${supplier.id}">Изменить данные</a> </th>
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
    <div>
        <a href="/admin/suppliers/insert" style="font-size: 18px; font-weight: bold;">Добавить нового поставщика</a>
    </div>
</@c.page>