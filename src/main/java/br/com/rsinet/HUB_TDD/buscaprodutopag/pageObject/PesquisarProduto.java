package br.com.rsinet.HUB_TDD.buscaprodutopag.pageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PesquisarProduto {

	public static void Execute(WebDriver driver) throws Exception {

		BuscaProduto.bt_mouse(driver).click();
		BuscaProduto.bt_mouseWir(driver).click();
		BuscaProduto.bt_addCar(driver).click();
		BuscaProduto.bt_Cart(driver).click();
		System.out.println("2: Produto Escolhido !");

		String busca = driver.getPageSource();

		Assert.assertTrue(busca.contains("/catalog/fetchImage?image_id=5200"));
	}
}
