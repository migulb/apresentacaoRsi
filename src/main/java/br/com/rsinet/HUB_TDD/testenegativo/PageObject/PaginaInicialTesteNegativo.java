package br.com.rsinet.HUB_TDD.testenegativo.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaInicialTesteNegativo {

	private static WebElement element;

	public static WebElement btn_notebook(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,400)", "");
		element = driver.findElement(By.id("details_10"));

		return element;

	}

	public static WebElement text_noteInicial(WebDriver driver) {

		element = driver.findElement(By.xpath("//p[@name='popular_item_10_name']"));

		return element;
	}

	public static WebElement text_noteFinal(WebDriver driver) {

		element = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']"));

		return element;
	}

}
