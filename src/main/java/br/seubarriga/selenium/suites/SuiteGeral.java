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

//package br.seuBarrigaTest.suites;
//
//import static br.seuBarrigaTest.core.DriverFactory.killDriver;
//
//import br.seuBarrigaTest.core.DriverFactory;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//import org.junit.runners.Suite.SuiteClasses;
//
//import br.seuBarrigaTest.pages.LoginPage;
//import br.seuBarrigaTest.tests.AccountTest;
//import br.seuBarrigaTest.tests.TransactionTest;
//import br.seuBarrigaTest.tests.RemoveTransactionAccountTest;
//import br.seuBarrigaTest.tests.SummaryTest;
//import br.seuBarrigaTest.tests.BalanceTest;
//
//@RunWith(Suite.class)
//@SuiteClasses({
//		AccountTest.class,
//		TransactionTest.class,
//		RemoveTransactionAccountTest.class,
//		BalanceTest.class,
//		SummaryTest.class
//})
//public class GeneralSuite {
//	private static LoginPage page = new LoginPage();
//
//	@BeforeClass
//	public static void reset() {
//		page.accessInitialScreen();
//
//		page.setEmail("amanda@resende");
//		page.setPassword("300697");
//		page.signIn();
//
//		System.out.println("🔄 Resetando antes dos testes...");
//		page.reset();
//
//		DriverFactory.killDriver();
//	}
//
//
//}
