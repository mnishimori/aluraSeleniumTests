package br.com.alura.leilao.login;

import br.com.alura.leilao.infrastructure.BrowserWebDriver;
import br.com.alura.leilao.leiloes.ListaLeilaoPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPageObject {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private static final String URL_LANCES = "http://localhost:8080/leiloes/2";

    private BrowserWebDriver browserWebDriver;

    public LoginPageObject(BrowserWebDriver browserWebDriver) {
        this.browserWebDriver = browserWebDriver;
    }

    public ListaLeilaoPageObject efetuarLoginUsuario(String username, String password) {
        this.navegarParaPaginaLogin();
        this.setarDadosUsuario(username, password);
        return this.submeterPaginaLogin();
    }

    public void navegarParaPaginaLogin() {
        this.browserWebDriver.getBrowser().navigate().to(URL_LOGIN);
    }

    public void setarDadosUsuario(String username, String password) {
        this.browserWebDriver.getBrowser().findElement(By.id("username")).sendKeys(username);
        this.browserWebDriver.getBrowser().findElement(By.id("password")).sendKeys(password);
    }

    public ListaLeilaoPageObject submeterPaginaLogin() {
        this.browserWebDriver.getBrowser().findElement(By.id("login-form")).submit();
        return new ListaLeilaoPageObject(browserWebDriver);
    }

    public String identificarNomeUsuarioLogado() {
        return this.browserWebDriver.getBrowser().findElement(By.id("usuario-logado")).getText();
    }

    public boolean isPaginaLogin() {
        return this.browserWebDriver.getBrowser().getCurrentUrl().equals(URL_LOGIN);
    }

    public String isUsuarioLogado() {
        try {
            return this.browserWebDriver.getBrowser().findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean isContainsString(String texto) {
        return this.browserWebDriver.getBrowser().getPageSource().contains(texto);
    }

    public void navegarParaPaginaLances() {
        this.browserWebDriver.getBrowser().navigate().to(URL_LANCES);
    }

    public BrowserWebDriver getBrowserWebDriver() {
        return browserWebDriver;
    }
}
