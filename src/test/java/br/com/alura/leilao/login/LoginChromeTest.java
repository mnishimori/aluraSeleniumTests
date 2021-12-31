package br.com.alura.leilao.login;

import br.com.alura.leilao.infrastructure.ChromeWebDriverImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginChromeTest extends LoginTemplateTest {

    public LoginChromeTest() {
        super.loginTemplatePageObject = new LoginPageObject(new ChromeWebDriverImpl());
    }

    @Test
    @Override
    protected void deveriaEfetuarLoginComDadosValidos() {
        super.loginTemplatePageObject.navegarParaPaginaLogin();
        super.loginTemplatePageObject.setarDadosUsuario("fulano", "pass");
        super.loginTemplatePageObject.submeterPaginaLogin();

        String nomeUsuarioLogado = super.loginTemplatePageObject.identificarNomeUsuarioLogado();
        Assertions.assertEquals("fulano", nomeUsuarioLogado);
        Assertions.assertFalse(super.loginTemplatePageObject.isPaginaLogin());
        System.out.println(super.loginTemplatePageObject.getBrowserWebDriver().getBrowser().getCurrentUrl());
    }

    @Test
    @Override
    protected void naoDeveriaEfetuarLoginComDadosInvalidos() {
        super.loginTemplatePageObject.navegarParaPaginaLogin();

        super.loginTemplatePageObject.setarDadosUsuario("invalido", "1234");
        super.loginTemplatePageObject.submeterPaginaLogin();

        Assertions.assertNull(super.loginTemplatePageObject.isUsuarioLogado());
        Assertions.assertFalse(super.loginTemplatePageObject.isPaginaLogin());
        Assertions.assertTrue(super.loginTemplatePageObject.isContainsString("Usuário e senha inválidos"));
    }

    @Test
    @Override
    protected void naoDeveriaAcessarUrlRestritaSemEstarLogado() {
        super.loginTemplatePageObject.navegarParaPaginaLances();

        Assertions.assertTrue(super.loginTemplatePageObject.isPaginaLogin());
        Assertions.assertFalse(super.loginTemplatePageObject.isContainsString("Dados do Leilão"));
    }
}
