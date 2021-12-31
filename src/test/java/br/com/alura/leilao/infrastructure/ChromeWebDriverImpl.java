package br.com.alura.leilao.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriverImpl implements BrowserWebDriver {

    protected WebDriver webDriver;

    public ChromeWebDriverImpl() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
    }

    public void iniciarNavegador() {
        this.webDriver = new ChromeDriver();
    }

    public void finalizarNavegador() {
        this.webDriver.quit();
    }

    public WebDriver getBrowser() {
        return webDriver;
    }
}
