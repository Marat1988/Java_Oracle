<#import "blocks/template.ftlh" as c>
<@c.page>
    <div class="card mb-3" style="width: 60%">
        <div class="row g-0">
            <div class="col-md-6">
                <img src="/images/${product.getImages()[0].getId()}"  alt="Фото товара" style="width: 100%">
            </div>
            <div class="col-md-6">
                <div class="card-body">
                    <h5 class="card-title">${product.title}</h5>
                    <p class="card-text">${product.description}</p>
                    <p class="card-text">${product.price} ₽</p>
                    <p class="card-text">${product.supplier.name}</p>
                    <p class="card-text">${product.group.name}</p>
                </div>
            </div>
        </div>
    </div>

    <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel"
         style="width: 35%; height: 35%; margin: 0 auto">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <#list product.getImages() as image>
                <div class="carousel-item  <#if image_index==0>active </#if>" data-bs-interval="2000">
                    <img src="/images/${image.id}" class="d-block w-100" alt="Фото товара">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>${product.title}</h5>
                        <p>${product.description}</p>
                    </div>
                </div>
            </#list>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

</@c.page>