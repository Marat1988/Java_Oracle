<#import "blocks/template.ftlh" as c>
<@c.page>
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">${user.getFullname()}</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/user/${user.id}">Личный кабинет</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/product/orders">История заказов</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/product/recycler">Корзина</a>
                    </li>
                    <#if user.isAdmin()>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Панель администратора
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="/admin/product/insert">Добавить товар</a></li>
                                <li><a class="dropdown-item" href="/admin/groups">Группы товаров</a></li>
                                <li><a class="dropdown-item" href="/admin/suppliers">Поставщики товаров</a></li>
                                <li><a class="dropdown-item" href="/admin/users">Пользователи</a></li>
                            </ul>
                        </li>
                    </#if>
                </ul>
                <form class="d-flex" action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="btn btn-outline-success" type="submit">Выйти из магазина</button>
                </form>
            </div>
        </div>
    </nav>

    <div class="row row-cols-1 row-cols-md-5">
        <#list products as product>
            <div class="col">
                <div class="card">
                    <img src="/images/${product.getImages()[0].getId()}" class="card-img-top" alt="Hollywood Sign on The Hill" height="150px"/>
                    <div class="card-body">
                        <h5 class="card-title">${product.title}</h5>
                        <p class="card-text">Цена: ${product.price} ₽</p>
                        <p class="card-text"><a href="/product/${product.id}" target="_blank">Подробнее</a></p>

                        <form action="/product/buy/${product.id}" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input type="submit" class="btn btn-primary" value="В корзину">
                        </form>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@c.page>