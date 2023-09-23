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
                                            <#if action==1>
                                                Изменение данных квартиры
                                            <#else>
                                                Добавление нового квартиры
                                            </#if>
                                        </h4>
                                    </div>
                                </div>
                            </div>
                            <form action="<#if action==1>/apartment/update<#else>/apartment/create</#if>"
                                  method="post">
                                <div class="row gy-3 overflow-hidden">
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="address" id="address"
                                                   value="<#if action==1>${apartment.address}</#if>" required>
                                            <label for="address" class="form-label">Адрес</label>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="number" class="form-control" name="roomCount" id="roomCount"
                                                   min="1"
                                                   value="<#if action==1>#{apartment.roomCount}</#if>" required>
                                            <label for="roomCount" class="form-label">Количество комнат</label>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="number" class="form-control" name="price" id="price" min="1"
                                                   value="<#if action==1>#{apartment.price}</#if>" required>
                                            <label for="price" class="form-label">Цена (за 1 месяц аренды)</label>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <select class="form-control" name="lenvatorId" id="lenvator" required>
                                            <#list lenvators as lenvator>
                                                <#if action==1>
                                                    <#if lenvator.id==apartment.lenvator.getId()>
                                                        <option value="${lenvator.id}"
                                                                selected>${lenvator.fullname}</option>
                                                    <#else>
                                                        <option value="${lenvator.id}">${lenvator.fullname}</option>
                                                    </#if>
                                                <#else>
                                                    <option value="${lenvator.id}">${lenvator.fullname}</option>
                                                </#if>
                                            </#list>
                                        </select>
                                        <label for="lenvator" class="form-label">ФИО арентодателя</label>
                                    </div>




                                    <#if action==1>
                                        <input type="hidden" value="${apartment.id}" name="id">
                                    </#if>
                                    <div class="col-12">
                                        <div class="d-grid">
                                            <button class="btn bsb-btn-xl btn-primary" type="submit">
                                                <#if action==1>
                                                    Сохранить изменения
                                                <#else>
                                                    Добавить новую квартиру
                                                </#if>
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