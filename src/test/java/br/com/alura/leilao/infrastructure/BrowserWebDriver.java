package br.com.alura.leilao.infrastructure;

import org.openqa.selenium.WebDriver;

public interface BrowserWebDriver {

    WebDriver getBrowser();

    void iniciarNavegador();

    void finalizarNavegador();

}
