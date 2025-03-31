package br.seubarriga.selenium.suites;

import static br.seubarriga.selenium.core.DriverFactory.killDriver;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.seubarriga.selenium.pages.LoginPage;
import br.seubarriga.selenium.tests.ContaTest;
import br.seubarriga.selenium.tests.MovimentacaoTest;
import br.seubarriga.selenium.tests.RemoverMovimentacaoContaTest;
import br.seubarriga.selenium.tests.ResumoTest;
import br.seubarriga.selenium.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();

	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.setEmail("amanda@resende");
		page.setSenha("300697");
		page.entrar();

		page.resetar();

		killDriver();
	}
}
