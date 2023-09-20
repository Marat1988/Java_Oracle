<#import "blocks/template.ftlh" as c>
<@c.page>
    <section class="vh-100 bg-image"
             style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                        <div class="card" style="border-radius: 15px;">
                            <div class="card-body p-5">
                                <h2 class="text-uppercase text-center mb-5">Интернет магазин ООО "Три брата". Форма регистрации.</h2>
                                <form action="/registration" method="post">
                                    <div class="form-outline mb-3">
                                        <input type="text" id="form3Example1cg" class="form-control form-control-lg"
                                               name="fullname"/>
                                        <label class="form-label" for="form3Example1cg">Введите ваше ФИО</label>
                                    </div>
                                    <div class="form-outline mb-3">
                                        <input type="email" id="form3Example3cg" class="form-control form-control-lg"
                                               name="email"/>
                                        <label class="form-label" for="form3Example3cg">Введите ваш email</label>
                                    </div>

                                    <div class="form-outline mb-3">
                                        <input type="text" id="form3Example4cg" class="form-control form-control-lg"
                                               name="phoneNumber"/>
                                        <label class="form-label" for="form3Example4cg">Введите номер телефона</label>
                                    </div>
                                    <div class="form-outline mb-3">
                                        <input type="text" id="form3Example4cdg" class="form-control form-control-lg"
                                               name="city"/>
                                        <label class="form-label" for="form3Example4cdg">Введите ваш город</label>
                                    </div>
                                    <div class="form-outline mb-3">
                                        <input type="password" id="password" class="form-control form-control-lg"
                                               name="password"/>
                                        <label class="form-label" for="password">Введите пароль</label>
                                    </div>
                                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                    <div class="d-flex justify-content-center">
                                        <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">
                                            Зарегистрироваться
                                        </button>
                                    </div>
                                    <p class="text-center text-muted mt-5 mb-0">Уже есть аккаунт? <a href="/login"
                                                                                                     class="fw-bold text-body"><u>Зайдите
                                                сюда</u></a></p>
                                </form>
                                <#if errorMessage??>
                                <h2 style="color: red">${errorMessage}</h2>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</@c.page>