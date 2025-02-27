package br.seubarriga.selenium.pages;

import org.openqa.selenium.By;

import br.seubarriga.selenium.core.BasePage;

public class ResumoPage extends BasePage {

		public void excluirMovimentacao(){
			clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
		}

		public String obterMensagemSucesso(){
			return obterTexto(By.xpath("//div[@role='alert']"));
		}

		public void selecionarAno(String ano){
			selecionarCombo("ano", ano);
		}

		public void buscar(){
			clicarBotao(By.xpath("//input[@value='Buscar']"));
		}
	}
