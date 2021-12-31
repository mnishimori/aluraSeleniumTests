package br.com.alura.leilao.login;

import br.com.alura.leilao.infrastructure.ChromeWebDriverImpl;

public class LoginChromeTest extends LoginTemplateTest {

    public LoginChromeTest() {
        super.loginTemplatePageObject = new LoginPageObject(new ChromeWebDriverImpl());
    }

}
