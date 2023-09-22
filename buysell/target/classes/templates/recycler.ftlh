<#import "blocks/template.ftlh" as c>
<@c.page>

    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Код товара</th>
            <th scope="col">Наименование товара</th>
            <th scope="col">Количество</th>
            <th scope="col">Цена</th>
            <th scope="col">Удалить</th>
        </tr>
        <#list recyclerAll as recycler>
            <tr>
                <th>${recycler.productId}</th>
                <th>${recycler.productName}</th>
                <th>
                    <form action="/product/recycle/update" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="hidden" name="id" value="${recycler.id}">
                        <input type="number" value="${recycler.quantity}" required min="1" name="quantity"/>
                        <input type="submit" class="btn btn-light" value="Обновить количество">
                    </form>
                </th>
                <th>${recycler.price}</th>
                <th>
                    <form action="/product/recycler/delete/${recycler.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" class="btn btn-light" value="Удалить">
                    </form>
                </th>
            </tr>
        <#else>
            <h3>Корзина пуста</h3>
        </#list>
    </table>
<#--    https://stackoverflow.com/questions/51026820/how-to-check-that-array-has-size-1-in-apache-freemarker-->
    <#if recyclerAll?size &gt; 0>
        <form action="/order/create" method="post">
            <div class="row gy-3 overflow-hidden">
                <div class="col-3">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" name="comment" id="comment" required/>
                        <label for="comment" class="form-label">комментарий</label>
                    </div>
                </div>
<#--                <input type="hidden" value="${user}" name="user">-->
                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <div class="col-3">
                    <div class="d-grid">
                        <button class="btn bsb-btn-xl btn-primary" type="submit">
                            Отправить заявку
                        </button>
                    </div>
                </div>
            </div>
        </form>
        <#else>
            <h4>Нет товары</h4>
    </#if>
</@c.page>