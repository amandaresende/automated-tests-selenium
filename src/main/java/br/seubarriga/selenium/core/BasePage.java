package br.seubarriga.selenium.core;

import static br.seubarriga.selenium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void escrever(By by, String texto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}

	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarBotaoPorTexto(String texto){
		clicarBotao(By.xpath("//button[.='"+texto+"']"));
	}

	public void clicarLink(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {

		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}

}