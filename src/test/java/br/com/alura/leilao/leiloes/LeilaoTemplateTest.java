package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class LeilaoTemplateTest {

    protected LoginPageObject loginPageObject;

    protected ListaLeilaoPageObject leilaoPageObject;

    protected CadastroLeilaoPageObject cadastroLeilaoPageObject;


    @BeforeEach
    protected void beforeEach() {
        this.cadastroLeilaoPageObject = this.getCadastroLeilaoPageObject();
    }

    @AfterEach
    protected void afterEach() {
        this.leilaoPageObject.getBrowserWebDriver().finalizarNavegador();
    }

    @Test
    protected void deveCadastrarLeilao() {
        // cenário
        String dataCadastro = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + dataCadastro;
        String valor = "500.00";

        // execução
        this.leilaoPageObject = this.cadastroLeilaoPageObject.cadastrarLeilao(nome, valor, dataCadastro);

        // verificação
        Assertions.assertTrue(this.leilaoPageObject.isLeilaoCadastrado(nome, valor, dataCadastro));
    }

    @Test
    protected void deveExibirMensagemDePreenchimentoDeCamposNecessariosAoCadastrarLeilao() {
        // cenário
        String dataCadastro = "";
        String nome = "";
        String valor = "";

        // execução
        this.leilaoPageObject = this.cadastroLeilaoPageObject.cadastrarLeilao(nome, valor, dataCadastro);

        // verificação
        Assertions.assertTrue(this.leilaoPageObject.isPaginaAtual());
        Assertions.assertTrue(this.leilaoPageObject.isMensagensValidacaoVisiveis());

    }

    private CadastroLeilaoPageObject getCadastroLeilaoPageObject() {
        this.loginPageObject = new LoginPageObject(this.leilaoPageObject.getBrowserWebDriver());

        this.leilaoPageObject = loginPageObject.efetuarLoginUsuario("fulano", "pass");

        return this.leilaoPageObject.carregarFormulario();
    }

}
