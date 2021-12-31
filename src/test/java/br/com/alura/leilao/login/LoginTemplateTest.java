package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class LoginTemplateTest {

	protected LoginTemplatePageObject loginTemplatePageObject;

	@BeforeEach
	protected void beforeEach() {
		this.loginTemplatePageObject.browserWebDriver.iniciarNavegador();
	}

	@AfterEach
	protected void afterEach() {
		this.loginTemplatePageObject.browserWebDriver.finalizarNavegador();
	}

	protected abstract void deveriaEfetuarLoginComDadosValidos();

	protected abstract void naoDeveriaEfetuarLoginComDadosInvalidos();

	protected abstract void naoDeveriaAcessarUrlRestritaSemEstarLogado();

}
