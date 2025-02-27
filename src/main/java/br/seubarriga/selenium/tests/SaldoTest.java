package br.seubarriga.selenium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.seubarriga.selenium.core.BaseTest;
import br.seubarriga.selenium.pages.HomePage;
import br.seubarriga.selenium.pages.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();

	@Test
	public void SaldoConta(){
		menu.acessarTelaPrincipal();
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
}
