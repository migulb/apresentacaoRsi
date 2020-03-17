package br.com.rsinet.HUB_TDD.buscaLupa.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaminhoDeBuscaPelaLupa {

	private static WebElement element = null;
	private WebDriver driver;
	
	
	public CaminhoDeBuscaPelaLupa(WebDriver driver) {
		this.driver = driver;
	}

	private static WebElement bt_Procura(WebDriver driver) {

		return driver.findElement(By.id("menuSearch"));
	}
	
	private static WebElement txt_nomeBusca(WebDriver driver) {

		return driver.findElement(By.id("autoComplete"));
	}

	private static WebElement bt_Produto(WebDriver driver) {

		return driver.findElement(By.id("30"));
	}

	private static WebElement bt_cart(WebDriver driver) {

		return driver.findElement(By.name("save_to_cart"));

	}

	private static WebElement bt_finalCart(WebDriver driver) {

		return driver.findElement(By.xpath("//tool-tip-cart[@id='toolTipCart']//div//table//tfoot"));
	}

	private static WebElement txt_Busca(WebDriver driver) {

		return driver.findElement(By.xpath("//span[contains(text(),'No results for \\\"Mesa\\\"')]"));
	}

	
	public void clicar_Lupa() {
		bt_Procura(driver).click();
	}
	
	public void digitar_Produto(String busca) {
		txt_nomeBusca(driver).click();
		txt_nomeBusca(driver).sendKeys(busca);
	}
	
	public void clica_produto() {
		bt_Produto(driver).click();
	}
	
	public void clicka_Carrinho() {
		bt_cart(driver).click();
	}
	
	public void finaliza_Compra() {
		bt_finalCart(driver).click();
	}
}
