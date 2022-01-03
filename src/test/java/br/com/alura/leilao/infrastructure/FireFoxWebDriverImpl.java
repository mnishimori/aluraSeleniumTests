package br.com.alura.leilao.infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FireFoxWebDriverImpl implements BrowserWebDriver {

    protected WebDriver webDriver;

    public FireFoxWebDriverImpl() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
    }

    public void iniciarNavegador() {
        this.webDriver = new FirefoxDriver();
        this.webDriver.manage().timeouts()
                .implicitlyWait(2, TimeUnit.SECONDS)
                .pageLoadTimeout(2, TimeUnit.SECONDS);
    }

    public void finalizarNavegador() {
        this.webDriver.quit();
    }

    public WebDriver getBrowser() {
        return webDriver;
    }
}
