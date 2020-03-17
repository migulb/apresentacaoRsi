package br.com.rsinet.HUB_TDD.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {

	private static WebElement element = null;
	private static WebDriver driver;
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		
	}

	private static WebElement menuLogin(WebDriver driver) {

		return driver.findElement(By.id("menuUser"));
	}

	private static WebElement bt_Cadastro(WebDriver driver) {

		return driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']"));

	}
	
	public void clickar_login() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(menuLogin(driver)));
		menuLogin(driver).click();
	}
	
	public void clickar_Cadastro() {
		bt_Cadastro(driver).sendKeys(Keys.ENTER);
	}
}
