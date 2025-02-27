package br.seubarriga.selenium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.seubarriga.selenium.core.BaseTest;
import br.seubarriga.selenium.pages.ContasPage;
import br.seubarriga.selenium.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void ExcluirContaComMovimentacao(){
		menuPage.acessarTelaListarConta();

		contasPage.clicarExcluirConta("Conta com movimentacao");

		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}
