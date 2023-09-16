<#import "blocks/template.ftlh" as c>
<@c.page>
    <section class="vh-100" style="background-color: #9A616D;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-xl-10">
                    <div class="card" style="border-radius: 1rem;">
                        <div class="row g-0">
                            <div class="col-md-6 col-lg-5 d-none d-md-block">
                                <img src="http://3.bp.blogspot.com/-wPW6LpcIk2k/Uwx0I2rUorI/AAAAAAAAFvk/ECU5qGpT9lQ/s1600/GRobson3.jpeg"
                                     alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;"/>
                            </div>
                            <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                <div class="card-body p-4 p-lg-5 text-black">
                                    <form action="/login" method="post">
                                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Введите ваши
                                            данные</h5>

                                        <div class="form-outline mb-4">
                                            <input type="email" id="form2Example17" class="form-control form-control-lg"
                                                   name="username"/>
                                            <label class="form-label" for="form2Example17">Email address</label>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="password" id="form2Example27"
                                                   class="form-control form-control-lg" name="password"/>
                                            <label class="form-label" for="form2Example27">Password</label>
                                        </div>
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                                        <div class="pt-1 mb-4">
                                            <button class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
                                        </div>
                                        <p class="mb-5 pb-lg-2" style="color: #393f81;">У вас еще нет аккаунта?
                                            <a href="/registration" style="color: #393f81;">Кликните сюда для
                                                регистрации</a>
                                        </p>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

<#--<h1>BUYSELL</h1>-->
<#--<h1>Авторизация</h1>-->
<#--<form action="/login" method="post">-->
<#--    Эл. почта: <input type="email" name="username"/><br><br>-->
<#--    Пароль: <input type="password" name="password"/><br><br>-->
<#--    <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
<#--    <input type="submit" value="Вход"/>-->
<#--</form>-->
<#--<a href="/registration">Зарегистрироваться</a>-->
</@c.page>