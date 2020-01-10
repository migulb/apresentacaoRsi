package br.com.rsinet.HUB_TDD.buscaprodutopag.pageObject;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_TDD.Constante;

public class TerceiraEtapa {

	private WebDriver driver;

	@Test
	public void main() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constante.URL);

		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.id("autoComplete")).sendKeys("Mouse");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions act = new Actions(driver);

		WebElement produto = driver.findElement(By.id("autoComplete"));
		wait.until(ExpectedConditions.elementToBeClickable(produto));

	}

}
