package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.infrastructure.BrowserWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListaLeilaoPageObject {

    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

    private BrowserWebDriver browserWebDriver;

    public ListaLeilaoPageObject(BrowserWebDriver browserWebDriver) {
        this.browserWebDriver = browserWebDriver;
    }

    public BrowserWebDriver getBrowserWebDriver() {
        return browserWebDriver;
    }

    public CadastroLeilaoPageObject carregarFormulario() {
        this.browserWebDriver.getBrowser().navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPageObject(this.browserWebDriver);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String dataCadastro) {
        WebElement linhaDaTabela = this.browserWebDriver.getBrowser()
                .findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));

        String colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)")).getText();
        String colunaValor = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)")).getText();
        String colunaDataCadastro = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)")).getText();

        return colunaNome.equals(nome) &&
                colunaValor.equals(valor) &&
                colunaDataCadastro.equals(dataCadastro);
    }
}
