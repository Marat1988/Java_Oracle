<#import "blocks/template.ftlh" as c>
<@c.page>
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">ООО "Три брата"</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Личный кабинет</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="https://dzen.ru/">История заказов</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Корзина</a>
                    </li>
                    <#if user.isAdmin()>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Панель администратора
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Добавить товар</a></li>
                                <li><a class="dropdown-item" href="#">Действия с группами товаров</a></li>
                                <li><a class="dropdown-item" href="#">Пользователи</a></li>
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
</@c.page>