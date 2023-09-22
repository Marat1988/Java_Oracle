<#import "blocks/template.ftlh" as c>
<@c.page>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Номер заказа</th>
            <th scope="col">Комментарий</th>
            <th scope="col">Дата заказа</th>
            <th scope="col">Сумма</th>
            <th scope="col">Подробнее</th>
        </tr>
        <#list orders as order>
            <tr>
                <th>${order.id}</th>
                <th>${order.comment}</th>
                <th>${order.dateOfCreated}</th>
                <#global sum = 0>
                <#list order.lineorders as lineorder>
                    <#global sum += lineorder.amount>
                </#list>
                <th>${sum}</th>
                <th><a href="/lineOrder/${order.id}" target="_blank">Попробнее</a></th>
            </tr>
        <#else>
            <h3>Заказов нет</h3>
        </#list>
    </table>
    <div class="homePage">
        <a href="/">На главную страницу</a>
    </div>
</@c.page>