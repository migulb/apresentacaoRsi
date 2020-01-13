package br.com.rsinet.HUB_TDD.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {

	private static WebElement element = null;

	public static WebElement menuLogin(WebDriver driver) {

		element = driver.findElement(By.id("menuUser"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		return element;
	}

	public static WebElement bt_Cadastro(WebDriver driver) {

		element = driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']"));

		return element;

	}
}
