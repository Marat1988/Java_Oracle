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
                                                Изменение данных аренды
                                            <#else>
                                                Добавление новой аренды
                                            </#if>
                                        </h4>
                                    </div>
                                </div>
                            </div>
                            <form action="<#if action==1>/rent/update<#else>/rent/create</#if>"
                                  method="post">
                                <div class="row gy-3 overflow-hidden">

                                    <div class="col-12">
                                        <select class="form-control" name="apartmentId" id="apartment" required>
                                            <#list apartments as apartment>
                                                <#if action==1>
                                                    <#if apartment.id==rent.apartment.id>
                                                        <option value="${apartment.id}"
                                                                selected>${apartment.address}</option>
                                                    <#else>
                                                        <option value="${apartment.id}">${apartment.address}</option>
                                                    </#if>
                                                <#else>
                                                    <option value="${apartment.id}">${apartment.address}</option>
                                                </#if>
                                            </#list>
                                        </select>
                                        <label for="apartment" class="form-label">Адрес квартиры</label>
                                    </div>
                                    <div class="col-12">
                                        <select class="form-control" name="renterId" id="renter" required>
                                            <#list renters as renter>
                                                <#if action==1>
                                                    <#if renter.id==rent.renter.id>
                                                        <option value="${renter.id}"
                                                                selected>${renter.fullname}</option>
                                                    <#else>
                                                        <option value="${renter.id}">${renter.fullname}</option>
                                                    </#if>
                                                <#else>
                                                    <option value="${renter.id}">${renter.fullname}</option>
                                                </#if>
                                            </#list>
                                        </select>
                                        <label for="renter" class="form-label">ФИО арендатора</label>
                                    </div>
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="date" class="form-control" name="dateTimeRent" id="dateTimeRent"
                                                   value="<#if action==1>${rent.dateTimeRent}</#if>" required>
                                            <label for="dateTimeRent" class="form-label">Дата начала аренды</label>
                                        </div>
                                    </div>
                                    <#if action==1>
                                        <input type="hidden" value="${rent.id}" name="id">
                                    </#if>
                                    <div class="col-12">
                                        <div class="d-grid">
                                            <button class="btn bsb-btn-xl btn-primary" type="submit">
                                                <#if action==1>
                                                    Сохранить изменения
                                                <#else>
                                                    Добавить аренду
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