package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.infrastructure.ChromeWebDriverImpl;

public class LeilaoChromeTest extends LeilaoTemplateTest {

    public LeilaoChromeTest() {
        super.leilaoPageObject = new ListaLeilaoPageObject(new ChromeWebDriverImpl());
        super.leilaoPageObject.getBrowserWebDriver().iniciarNavegador();
    }

}
