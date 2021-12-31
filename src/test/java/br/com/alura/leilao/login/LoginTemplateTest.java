package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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

	protected abstract void deveriaEfetuarLoginComDadosValidos();

	protected abstract void naoDeveriaEfetuarLoginComDadosInvalidos();

	protected abstract void naoDeveriaAcessarUrlRestritaSemEstarLogado();

}
