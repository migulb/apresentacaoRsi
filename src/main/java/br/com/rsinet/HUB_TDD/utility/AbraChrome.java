package br.com.rsinet.HUB_TDD.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.HUB_TDD.Constante;

public class AbraChrome {

	public static WebDriver abrirChrome() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constante.URL);

		return driver;
	}
}
