package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.infrastructure.BrowserWebDriver;
import br.com.alura.leilao.util.PageObject;
import org.openqa.selenium.By;

public class CadastroLeilaoPageObject extends PageObject {

    public CadastroLeilaoPageObject(BrowserWebDriver browserWebDriver) {
        super(browserWebDriver);
    }

    public ListaLeilaoPageObject cadastrarLeilao(String nome, String valor, String dataAbertura) {
        this.browserWebDriver.getBrowser().findElement(By.id("nome")).sendKeys(nome);
        this.browserWebDriver.getBrowser().findElement(By.id("valorInicial")).sendKeys(valor);
        this.browserWebDriver.getBrowser().findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.browserWebDriver.getBrowser().findElement(By.id("button-submit")).submit();

        return new ListaLeilaoPageObject(this.browserWebDriver);
    }

}
