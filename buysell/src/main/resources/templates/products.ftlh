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


        <div class="row main">
            <div class="col-2 search">
                <h4>Поиск товара</h4>
                <form action="/product/find" method="get">
                    <div class="form-floating mb-3">
                        <select class="form-control" name="supplierId" id="supplier" required>
                            <option value="0">Все поставщики</option>
                            <#list suppliers as supplier>
                                <option value="${supplier.id}">${supplier.name}</option>
                            </#list>
                        </select>
                        <label for="supplier" class="form-label">Выберите поставщика товара</label>
                    </div>
                    <div class="form mb-3">
                        <label for="priceBegin"  class="form-label">Цена между</label>
                        <input class="form-control" type="number" min="1" max="1000000" name="priceBegin" id="priceBegin" value="1" required/>
                        <label for="priceEnd"  class="form-label">И</label>
                        <input class="form-control" type="number" min="1" max="1000000" name="priceEnd" id="priceEnd" value="1000000" required/>
                    </div>
                    <div>
                        <button class="btn btn-outline-success" type="submit">Поиск</button>
                    </div>
                </form>
            </div>
            <div class="col-10 products">
                <h4>Фото товара</h4>
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
            </div>
        </div>




</@c.page>