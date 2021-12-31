package br.com.alura.leilao.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxWebDriverImpl implements BrowserWebDriver {

    protected WebDriver webDriver;

    public FireFoxWebDriverImpl() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
    }

    public void iniciarNavegador() {
        this.webDriver = new FirefoxDriver();
    }

    public void finalizarNavegador() {
        this.webDriver.quit();
    }

    public WebDriver getBrowser() {
        return webDriver;
    }
}
