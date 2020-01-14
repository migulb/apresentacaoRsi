package br.com.rsinet.HUB_TDD.buscaprodutopag;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.Constante;
import br.com.rsinet.HUB_TDD.buscaprodutopag.pageObject.BuscaProduto;

public class SegundaEtapa {

	private WebDriver driver;

	@Test(priority = 0)
	public void AbriNavegador() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constante.URL);
		System.out.println("1: Navegador Aberto e página inicializada");
	}

	@Test(priority = 1)
	public void EscolherPrduto() {
		BuscaProduto.bt_mouse(driver).click();
		BuscaProduto.bt_mouseWir(driver).click();
		BuscaProduto.bt_addCar(driver).click();
		BuscaProduto.bt_Cart(driver).click();
		System.out.println("2: Produto Escolhido !");
	}

	@Test(priority = 2)
	public void fecharNavegador() {
//			driver.quit();
	}
}
