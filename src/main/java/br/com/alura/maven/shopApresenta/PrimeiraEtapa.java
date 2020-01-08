package br.com.alura.maven.shopApresenta;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PrimeiraEtapa {

	private WebDriver driver;

	@Test
	public void main() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get(Constante.URL);

		Actions act = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.id("menuUser")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(3000);
		WebElement cadas = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		cadas.click();
		driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[1]/sec-view[1]/div/input")).sendKeys("MiguelBR");

		driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[1]/sec-view[2]/div/input"))
				.sendKeys("migul@email.com");
		driver.findElement(By.name("passwordRegisterPage")).sendKeys("96Miguel.");
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("96Miguel.");
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Miguel");
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Bruno");
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("99999999999");

		WebElement pais = driver.findElement(By.name("countryListboxRegisterPage"));
		new Select(pais).selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Taboão da Serra");
		driver.findElement(By.name("addressRegisterPage")).sendKeys("Rua tal de tal");
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("São Paulo");
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("00000000");
		driver.findElement(By.name("i_agree")).click();
		driver.findElement(By.id("register_btnundefined")).click();

	}

}
