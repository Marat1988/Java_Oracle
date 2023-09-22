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
                                                Изменение данных группы
                                            <#else>
                                                Добавление нового поставщика
                                            </#if>
                                        </h4>
                                    </div>
                                </div>
                            </div>
                            <form action="<#if action==1>/admin/groups/update<#else>/admin/groups/create</#if>"
                                  method="post">
                                <div class="row gy-3 overflow-hidden">
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="name" id="name"
                                                   value="<#if action==1>${group.name}</#if>" required>
                                            <label for="name" class="form-label">Название группы</label>
                                        </div>
                                    </div>
                                    <#if action==1>
                                        <input type="hidden" value="${group.id}" name="groupId">
                                    </#if>
                                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                                    <div class="col-12">
                                        <div class="d-grid">
                                            <button class="btn bsb-btn-xl btn-primary" type="submit">
                                                <#if action==1>
                                                    Сохранить изменения
                                                <#else>
                                                    Добавить новую группу товара
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