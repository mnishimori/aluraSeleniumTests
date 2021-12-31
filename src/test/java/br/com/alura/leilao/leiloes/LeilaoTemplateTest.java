package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class LeilaoTemplateTest {

    protected ListaLeilaoPageObject leilaoPageObject;

    //@AfterEach
    protected void afterEach() {
        this.leilaoPageObject.getBrowserWebDriver().finalizarNavegador();
    }

    @Test
    protected void deveCadastrarLeilao() {
        // cenário
        LoginPageObject loginPageObject = new LoginPageObject(this.leilaoPageObject.getBrowserWebDriver());

        this.leilaoPageObject = loginPageObject.efetuarLoginUsuario("fulano", "pass");

        CadastroLeilaoPageObject cadastroLeilaoPageObject = this.leilaoPageObject.carregarFormulario();

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + hoje;
        String valor = "500.00";

        // execução
        this.leilaoPageObject = cadastroLeilaoPageObject.cadastrarLeilao(nome, valor, hoje);

        // verificação
        Assertions.assertTrue(this.leilaoPageObject.isLeilaoCadastrado(nome, valor, hoje));
    }

}
