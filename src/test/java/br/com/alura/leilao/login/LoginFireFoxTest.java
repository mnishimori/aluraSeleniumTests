package br.com.alura.leilao.login;

import br.com.alura.leilao.infrastructure.FireFoxWebDriverImpl;

public class LoginFireFoxTest extends LoginTemplateTest {

    public LoginFireFoxTest() {
        super.loginTemplatePageObject = new LoginPageObject(new FireFoxWebDriverImpl());
    }

}
