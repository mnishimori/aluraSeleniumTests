package br.com.alura.leilao.util;

import br.com.alura.leilao.infrastructure.BrowserWebDriver;

public abstract class PageObject {

    protected BrowserWebDriver browserWebDriver;

    protected PageObject(BrowserWebDriver browserWebDriver){
        this.browserWebDriver = browserWebDriver;
    }

    public BrowserWebDriver getBrowserWebDriver() {
        return browserWebDriver;
    }
}
