<#import "blocks/template.ftlh" as c>
<@c.page>
    <section class="bg-light p-3 p-md-4 p-xl-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6 col-xxl-5">
                    <div class="card border border-light-subtle rounded-4">
                        <div class="card-body p-3 p-md-4 p-xl-5">
                            <div class="row">
                                <div class="col-12">
                                    <div class="mb-5">
                                        <h4 class="text-center">
                                            Добавление нового товара
                                        </h4>
                                    </div>
                                </div>
                            </div>
                            <form action="/admin/product/create" method="post" enctype="multipart/form-data">
                                <div class="row gy-3 overflow-hidden">
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="title" id="title" required>
                                            <label for="title" class="form-label">Название товара</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="description" id="description"
                                                   required>
                                            <label for="description" class="form-label">Описание товара</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input type="number" class="form-control" name="price" id="price" required>
                                            <label for="price" class="form-label">Цена</label>
                                        </div>

                                        <div class="form-floating mb-3">
                                            <select class="form-control" name="groupId" id="group" required>
                                                <#list groups as group>
                                                    <option value="${group.id}">${group.name}</option>
                                                </#list>
                                            </select>
                                            <label for="group" class="form-label">Группа товара</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <select class="form-control" name="supplierId" id="supplier" required>
                                                <#list suppliers as supplier>
                                                    <option value="${supplier.id}">${supplier.name}</option>
                                                </#list>
                                            </select>
                                            <label for="supplier" class="form-label">Поставщик товара</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input type="file" class="form-control" name="file1" id="file1" required>
                                            <label for="file1" class="form-label">Первая фотография</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input type="file" class="form-control" name="file2" id="file2">
                                            <label for="file2" class="form-label">Вторая фотография</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input type="file" class="form-control" name="file3" id="file3">
                                            <label for="file3" class="form-label">Третья фотография</label>
                                        </div>
                                    </div>
                                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                                    <div class="col-12">
                                        <div class="d-grid">
                                            <button class="btn bsb-btn-xl btn-primary" type="submit">
                                               Добавить новый товар
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</@c.page>