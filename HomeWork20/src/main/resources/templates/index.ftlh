<#import "blocks/template.ftlh" as c>
<@c.page>
    <nav class="navbar sticky-top navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="https://klg.top-academy.ru/">Панель навигации</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/lenvators">Арентодатели</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/apartments">Квартиры</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/renters">Арендаторы</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/rents">Аренда квартир</a>
                    </li>
                    <li>
                        <button type="button" class="btn-primary" onclick=getInformation()>
                            Отобразить информацию (максимальная, минимальная средняя цена)</button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="information"></div>

</@c.page>