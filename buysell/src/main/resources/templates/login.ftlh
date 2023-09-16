<#import "blocks/template.ftlh" as c>
<@c.page>
    <section class="vh-100" style="background-color: #9A616D;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col col-xl-10">
                    <div class="card" style="border-radius: 1rem;">
                        <div class="row g-0">
                            <div class="col-md-6 col-lg-5 d-none d-md-block">
                                <img src="https://yandex-images.clstorage.net/5oW0N1H86/3baac5AHv/MQTwmSopSjeXsR9eJbPdBYvKEvQQ4IfFz1EbSYp-zMZiFQhye36lDZvsvHPn9z6FpWLoy4UqMqeIDNT3jLl47iwMrflWSAcrgoULHw3T-EyC-nPMyBAjWNd9KwSWMiRr0pWw3sPTPNRiCb0qnqIXrJhr_XY5a9dGMDho9qB8pYu5UC2kj4n-a6Mpl0ogTwG5jn7CZOgoN4AncQs0gtL824KpvC7DQ_CErp35KiLSiym4dzWOIDsrRkzQ4EKIgJUj6VzpxM-1Rj_3wY-awE8BqVpe3sxMMEMoKzmnUIrGgAvazWDiozcQDPJZFYYq5ocFwIcN7mBvk1LMHETSLAgNF-l0MUy71QprV0m3MvxLccWWPrJACDDPHF99G3DWOsyHhglYGmvTcGzyOZmawi4j6Qyz-eqMs2cWNNS0hkBQNWuFhNW4r_Uq3ytNL4okHwGpDpYivAC8h7TTcUM4JtpAD5rxpMo_s6gcFg0BFgq2w2mYB3EGYM-zwkQ8tCqoCBVrXVBx0Kct7g8PZQMSbL8J_fqypmyIZDMQX3kHCCImwKPu2SjuJzdAUBo9MZ7yAqPJdHOVGvgPb_LoYEg2eNDJf7UIqVRbKWrzu9GvWiBjoRHWrsrUAOyPCJNFC_yWeuQjdl084idDWCgKAY2GjipD4XznObaMc0--1IiYstDobX_BkG2sM13G1wP9C4JMjzUp4sbaSLD0g5zfYes0lrIE88r5NJ7j2zwMbg1BTmoSo4FwZznOrFPrIiQgxNqgGDnnxcit5KeRZkubMQe-eBsByYZScrR0qHcMzzWnjB4i-EuyqSAG-z-I5A5tbRYaErOBcLftmpRD6yJU5IRKeFw12_3UCZgnPXojM7GvNtCDAT2aJkI8_BAblLtd11imapBDsknsFq9zfMyGEc2yZo6riYgHaZp8Y8vGvKRsxlT0AYdNbKV4182aW6Nl3yrI19U9yibuMBzogzxn0R8kcrJU"
                                     alt="login form" class="img-fluid"
                                     style="border-radius: 1rem 0 0 1rem; width: 100%; height: 100%"/>
                            </div>
                            <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                <div class="card-body p-4 p-lg-5 text-black">
                                    <form action="/login" method="post">
                                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Интернет магазин
                                            ООО "Три брата". Форма входа</h5>

                                        <div class="form-outline mb-4">
                                            <input type="email" id="form2Example17" class="form-control form-control-lg"
                                                   name="username"/>
                                            <label class="form-label" for="form2Example17">Электронная почта</label>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="password" id="form2Example27"
                                                   class="form-control form-control-lg" name="password"/>
                                            <label class="form-label" for="form2Example27">Пароль</label>
                                        </div>
                                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                        <div class="pt-1 mb-4">
                                            <button class="btn btn-dark btn-lg btn-block" type="submit">Войти</button>
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
</@c.page>