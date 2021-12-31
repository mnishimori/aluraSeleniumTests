package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class LoginTemplateTest {

	protected LoginPageObject loginTemplatePageObject;

	@BeforeEach
	protected void beforeEach() {
		this.loginTemplatePageObject.getBrowserWebDriver().iniciarNavegador();
	}

	@AfterEach
	protected void afterEach() {
		this.loginTemplatePageObject.getBrowserWebDriver().finalizarNavegador();
	}

	@Test
	protected void deveriaEfetuarLoginComDadosValidos() {
		this.loginTemplatePageObject.navegarParaPaginaLogin();
		this.loginTemplatePageObject.setarDadosUsuario("fulano", "pass");
		this.loginTemplatePageObject.submeterPaginaLogin();

		String nomeUsuarioLogado = this.loginTemplatePageObject.identificarNomeUsuarioLogado();
		Assertions.assertEquals("fulano", nomeUsuarioLogado);
		Assertions.assertFalse(this.loginTemplatePageObject.isPaginaLogin());
	}

	@Test
	protected void naoDeveriaEfetuarLoginComDadosInvalidos() {
		this.loginTemplatePageObject.navegarParaPaginaLogin();

		this.loginTemplatePageObject.setarDadosUsuario("invalido", "1234");
		this.loginTemplatePageObject.submeterPaginaLogin();

		Assertions.assertNull(this.loginTemplatePageObject.isUsuarioLogado());
		Assertions.assertFalse(this.loginTemplatePageObject.isPaginaLogin());
		Assertions.assertTrue(this.loginTemplatePageObject.isContainsString("Usuário e senha inválidos"));
	}

	@Test
	protected void naoDeveriaAcessarUrlRestritaSemEstarLogado() {
		this.loginTemplatePageObject.navegarParaPaginaLances();

		Assertions.assertTrue(this.loginTemplatePageObject.isPaginaLogin());
		Assertions.assertFalse(this.loginTemplatePageObject.isContainsString("Dados do Leilão"));
	}

}
