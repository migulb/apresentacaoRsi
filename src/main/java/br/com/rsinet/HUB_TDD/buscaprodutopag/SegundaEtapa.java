package br.com.rsinet.HUB_TDD.buscaprodutopag;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.HUB_TDD.Constante;
import br.com.rsinet.HUB_TDD.buscaprodutopag.pageObject.BuscaProduto;

public class SegundaEtapa {

	private WebDriver driver;

	@Test
	public void main() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constante.URL);

		BuscaProduto.bt_mouse(driver).click();
		BuscaProduto.bt_mouseWir(driver).click();
		BuscaProduto.bt_addCar(driver).click();
		BuscaProduto.bt_Cart(driver).click();

	}
}
