<#import "blocks/template.ftlh" as c>
<@c.page>
    <h1>Информация о заказе номер ${numberOrder}</h1>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Товар</th>
            <th scope="col">Цена</th>
            <th scope="col">Количество</th>
            <th scope="col">Сумма</th>
        </tr>
        <#list lineOrders as lineOrder>
            <tr>
                <th>${lineOrder.productline.title}</th>
                <th>${lineOrder.price}</th>
                <th>${lineOrder.quantity}</th>
                <th>${lineOrder.amount}</th>
            </tr>
        <#else>
            <h3>Заявок нет</h3>
        </#list>
    </table>
</@c.page>