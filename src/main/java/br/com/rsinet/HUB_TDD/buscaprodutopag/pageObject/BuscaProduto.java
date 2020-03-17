package br.com.rsinet.HUB_TDD.buscaprodutopag.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaProduto {

	private static WebElement element = null;
	private static WebDriver driver;
	
	public BuscaProduto(WebDriver driver) {
		this.driver = driver;
	}
	private static WebElement bt_categoria(WebDriver driver) {

		return driver.findElement(By.id("miceImg"));
	}

	private static WebElement bt_mouseWir(WebDriver driver) {

		return driver.findElement(By.id("27"));
	}

	private static WebElement bt_addCar(WebDriver driver) {
		
		return driver.findElement(By.name("save_to_cart"));
	}

	private static WebElement bt_Cart(WebDriver driver) {

		return  driver.findElement(By.xpath("//header//tfoot//td[2]"));
	}
	
	private static WebElement btn_Notebook(WebDriver driver) {
		
		return driver.findElement(By.id("details_10"));
	}

	
	public void click_categoria() {
		bt_categoria(driver).click();
	}
	
	public void click_MouseEspecifico() {
		bt_mouseWir(driver).click();
	}
	
	public void adiciona_carrinho() {
		bt_addCar(driver).click();
	}
	
	public void carrinho() {
		bt_Cart(driver).click();
	}
	
	public void clicka_Notebook() {
		btn_Notebook(driver).click();
	}
}
