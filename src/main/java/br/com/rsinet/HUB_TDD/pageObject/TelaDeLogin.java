package br.com.rsinet.HUB_TDD.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TelaDeLogin {

	public static void Execute(WebDriver driver) throws InterruptedException {

		Home_Page.menuLogin(driver).click();

		Home_Page.bt_Cadastro(driver).sendKeys(Keys.ENTER);

	}
}
