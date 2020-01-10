package br.com.rsinet.HUB_TDD.buscaprodutopag.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaProduto {

	private static WebElement element = null;

	public static WebElement bt_mouse(WebDriver driver) {

		element = driver.findElement(By.id("miceImg"));

		return element;
	}

	public static WebElement bt_mouseWir(WebDriver driver) {

		element = driver.findElement(By.id("27"));

		return element;
	}

	public static WebElement bt_addCar(WebDriver driver) {

		element = driver.findElement(By.name("save_to_cart"));

		return element;
	}

	public static WebElement bt_Cart(WebDriver driver) {

		element = driver.findElement(By.xpath("//header//tfoot//td[2]"));

		return element;
	}
}
