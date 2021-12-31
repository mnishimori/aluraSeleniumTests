package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.infrastructure.BrowserWebDriver;
import org.openqa.selenium.By;

public class CadastroLeilaoPageObject {

    private BrowserWebDriver browserWebDriver;

    public CadastroLeilaoPageObject(BrowserWebDriver browserWebDriver) {
        this.browserWebDriver = browserWebDriver;
    }

    public BrowserWebDriver getBrowserWebDriver() {
        return browserWebDriver;
    }

    public ListaLeilaoPageObject cadastrarLeilao(String nome, String valor, String dataAbertura) {
        this.browserWebDriver.getBrowser().findElement(By.id("nome")).sendKeys(nome);
        this.browserWebDriver.getBrowser().findElement(By.id("valorInicial")).sendKeys(valor);
        this.browserWebDriver.getBrowser().findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.browserWebDriver.getBrowser().findElement(By.id("button-submit")).submit();

        return new ListaLeilaoPageObject(this.browserWebDriver);
    }
}
