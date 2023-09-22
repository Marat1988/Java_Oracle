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
                                        <h4 class="text-center">Изменение данных пользователя</h4>
                                    </div>
                                </div>
                            </div>
                            <form action="/admin/users/update" method="post">
                                <div class="row gy-3 overflow-hidden">
                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="fullname" id="fullname" value="${user.fullname}"  required>
                                            <label for="fullname" class="form-label">ФИО</label>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="city" id="city" value="${user.city}"  required>
                                            <label for="city" class="form-label">Город</label>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" value="${user.phoneNumber}"  required>
                                            <label for="phoneNumber" class="form-label">Почта</label>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <div class="form-floating mb-3">
                                            <input type="email" class="form-control" name="email" id="email" value="${user.email}"  required>
                                            <label for="email" class="form-label">Email</label>
                                        </div>
                                    </div>
                                    <input type="hidden" value="${user.id}" name="userId">
                                    <input type="hidden" value="${_csrf.token}" name="_csrf">
                                    <div class="col-12">
                                        <div class="d-grid">
                                            <button class="btn bsb-btn-xl btn-primary" type="submit">Сохранить изменения</button>
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