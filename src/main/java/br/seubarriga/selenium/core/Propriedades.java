package br.seubarriga.selenium.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;

	public static Browsers BROWSER = Browsers.FIREFOX;

	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;

	public enum Browsers {
		FIREFOX,
		CHROME
	}

	public enum TipoExecucao {
		LOCAL,
		GRID
	}
}

