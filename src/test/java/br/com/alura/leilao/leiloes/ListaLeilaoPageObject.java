package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.infrastructure.BrowserWebDriver;
import br.com.alura.leilao.util.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ListaLeilaoPageObject extends PageObject {

    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

    private static final String URL_LISTA_LEILOES = "http://localhost:8080/leiloes";

    public ListaLeilaoPageObject(BrowserWebDriver browserWebDriver) {
        super(browserWebDriver);
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

    public boolean isPaginaAtual() {
        return this.browserWebDriver.getBrowser().getCurrentUrl().equals(URL_LISTA_LEILOES);
    }

    public boolean isMensagensValidacaoVisiveis() {
        String pageSource = this.browserWebDriver.getBrowser().getPageSource();

        return pageSource.contains("não deve estar em branco") &&
                pageSource.contains("minimo 3 caracteres") &&
                pageSource.contains("deve ser um valor maior de 0.1") &&
                pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}
