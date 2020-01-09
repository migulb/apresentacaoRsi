package br.com.rsinet.HUB_TDD.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cadastro {
	private static WebElement element = null;

	public static WebElement btt_cadastro(WebDriver driver) {

		element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));

		return element;

	}

	public static WebElement tx_Usuario(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\\\"formCover\\\"]/div[1]/div[1]/sec-view[1]/div/input"));

		return element;
	}

	public static WebElement tx_email(WebDriver driver) {

		element = driver.findElement(By.xpath(""));

		return element;
	}
	
}
