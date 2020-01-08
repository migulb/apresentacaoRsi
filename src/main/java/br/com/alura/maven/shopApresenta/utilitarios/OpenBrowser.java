package br.com.alura.maven.shopApresenta.utilitarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import br.com.alura.maven.shopApresenta.Constante;

public class OpenBrowser {

	public static WebDriver driver = null;

	public static WebDriver openBrowser(int iTestCaseRow) throws Exception {

		String sBrowserName = null;

		try {
			if (sBrowserName.equals("Google Chrome")) {

				driver = new ChromeDriver();

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				driver.get(Constante.URL);

			} else if (sBrowserName.equals("Internet Explore")) {
				System.setProperty("webdriver.chrome.driver", "C:\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(Constante.URL);

			}
		} catch (Exception e) {
			System.out.println("Erro ao navegar na página" + e.getMessage());
		}
		return driver;
	}
}
