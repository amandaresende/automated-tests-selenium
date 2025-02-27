package br.seubarriga.selenium.core;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };

    private DriverFactory() {}

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;

        if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {
            switch (Propriedades.BROWSER) {
                case FIREFOX:

                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                    throw new IllegalArgumentException("Navegador não suportado: " + Propriedades.BROWSER);
            }
        }

        if (driver != null) {
            driver.manage().window().setPosition(new Point(0, 0));
        }
        return driver;
    }

    public static void killDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            threadDriver.remove();
        }
    }
}

