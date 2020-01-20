package br.com.rsinet.HUB_TDD.buscaLupa.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class ProcurarProduto {

	public static void Execute(WebDriver driver) throws Exception {
		CaminhoDeBuscaPelaLupa.bt_Procura(driver).click();
		CaminhoDeBuscaPelaLupa.txt_nomeBusca(driver).click();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		CaminhoDeBuscaPelaLupa.txt_nomeBusca(driver).sendKeys(ExcelUtil.getCellData(1, 1) + Keys.ENTER);
		CaminhoDeBuscaPelaLupa.bt_Produto(driver).click();
		CaminhoDeBuscaPelaLupa.bt_cart(driver).click();
		CaminhoDeBuscaPelaLupa.bt_finalCart(driver).click();

		String busca = driver.getPageSource();
		String produto = "HP Z4000 WIRELESS MOUSE";
		Assert.assertTrue(busca.contains(produto));
	}
}
