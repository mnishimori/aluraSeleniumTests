package br.com.alura.leilao.login;

import br.com.alura.leilao.infrastructure.FireFoxWebDriverImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginFireFoxTest extends LoginTemplateTest {

    public LoginFireFoxTest() {
        super.loginTemplatePageObject = new LoginPageObject(new FireFoxWebDriverImpl());
    }

    @BeforeEach
    protected void beforeEach() {
        super.beforeEach();
    }

    @AfterEach
    protected void afterEach() {
        super.afterEach();
    }

    @Test
    @Override
    protected void deveriaEfetuarLoginComDadosValidos() {
        super.loginTemplatePageObject.navegarParaPaginaLogin();
        super.loginTemplatePageObject.setarDadosUsuario("fulano", "pass");
        super.loginTemplatePageObject.submeterPaginaLogin();

        System.out.println(super.loginTemplatePageObject.getBrowserWebDriver().getBrowser().getCurrentUrl());
    }

    @Override
    protected void naoDeveriaEfetuarLoginComDadosInvalidos() {
    }

    @Override
    protected void naoDeveriaAcessarUrlRestritaSemEstarLogado() {
    }

}
