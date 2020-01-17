package br.com.rsinet.HUB_TDD.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbraChrome {

	private static WebDriver driver;

	public static WebDriver inicializarDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.get(Constante.URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		return driver;
	}

	public static void fecharDriver() {
		if (driver != null)
			driver.quit();
		driver = null;
	}
}
