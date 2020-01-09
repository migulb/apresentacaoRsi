package br.com.rsinet.HUB_TDD.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {

	private static WebElement element = null;

	public static WebElement minhaConta(WebDriver driver) {

		element = driver.findElement(By.id("menuUser"));

		return element;

	}
}
