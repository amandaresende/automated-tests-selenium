package br.seubarriga.selenium.tests;

import static br.seubarriga.selenium.core.DriverFactory.getDriver;

import br.seubarriga.selenium.core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;

import br.seubarriga.selenium.core.BaseTest;
import br.seubarriga.selenium.pages.MenuPage;
import br.seubarriga.selenium.pages.ResumoPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResumoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();

	@Test
	public void ExcluirMovimentacao(){
		menuPage.acessarTelaResumo();

		resumoPage.excluirMovimentacao();

		Assert.assertEquals("Movimentação removida com sucesso!",
				resumoPage.obterMensagemSucesso());
	}

	@Test
	public void ResumoMensal(){
		menuPage.acessarTelaResumo();

		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

		resumoPage.selecionarAno("2016");
		resumoPage.buscar();

		List<WebElement> elementosEncontrados =
				DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());

	}
}




