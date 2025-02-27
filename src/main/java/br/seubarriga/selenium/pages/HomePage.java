package br.seubarriga.selenium.pages;

import br.seubarriga.selenium.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldoConta(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();

	}
}


