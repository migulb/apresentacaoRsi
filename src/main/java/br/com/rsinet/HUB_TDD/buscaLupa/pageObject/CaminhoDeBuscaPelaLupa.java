package br.com.rsinet.HUB_TDD.buscaLupa.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaminhoDeBuscaPelaLupa {

	private static WebElement element = null;

	public static WebElement bt_Procura(WebDriver driver) {

		element = driver.findElement(By.id("menuSearch"));

		return element;

	}

	public static WebElement txt_nomeBusca(WebDriver driver) {

		element = driver.findElement(By.id("autoComplete"));

		return element;
	}

	public static WebElement bt_Produto(WebDriver driver) {

		element = driver.findElement(By.id("30"));

		return element;
	}

	public static WebElement bt_cart(WebDriver driver) {

		element = driver.findElement(By.name("save_to_cart"));

		return element;

	}

	public static WebElement bt_finalCart(WebDriver driver) {

		element = driver.findElement(By.xpath("//tool-tip-cart[@id='toolTipCart']//div//table//tfoot"));

		return element;
	}

	public static WebElement txt_Busca(WebDriver driver) {

		element = driver.findElement(By.xpath("//span[contains(text(),'No results for \\\"Mesa\\\"')]"));

		return element;
	}

}
