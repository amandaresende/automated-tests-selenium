package br.seubarriga.selenium.pages;

import org.openqa.selenium.By;

import br.seubarriga.selenium.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escrever("nome", nome);
	}

	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}

	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@role='alert']"));
	}

	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@role='alert']"));
	}

	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
				.findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();

	}

	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
				.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();

	}
}

