package br.com.rsinet.HUB_TDD.pageObject;

import org.openqa.selenium.WebDriver;

public class TelaDeLogin {

	public static void Execute(WebDriver driver) throws InterruptedException {

		Home_Page.menuLogin(driver).click();

		Thread.sleep(5000);
		Home_Page.bt_Cadastro(driver).click();

	}
}
