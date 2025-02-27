package br.seubarriga.selenium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.seubarriga.selenium.core.BaseTest;
import br.seubarriga.selenium.pages.ContasPage;
import br.seubarriga.selenium.pages.MenuPage;

public class ContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void InserirConta(){
		menuPage.acessarTelaInserirConta();

		contasPage.setNome("Conta do Teste");
		contasPage.salvar();

		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void AlterarConta(){
		menuPage.acessarTelaListarConta();

		contasPage.clicarAlterarConta("Conta para alterar");

		contasPage.setNome("Conta alterada");
		contasPage.salvar();

		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void InserirContaMesmoNome(){
		menuPage.acessarTelaInserirConta();

		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();

		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
}
