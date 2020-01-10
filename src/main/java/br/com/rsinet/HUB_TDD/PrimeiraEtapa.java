package br.com.rsinet.HUB_TDD;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.rsinet.HUB_TDD.pageObject.Cadastro;
import br.com.rsinet.HUB_TDD.pageObject.TelaDeLogin;

public class PrimeiraEtapa {

	private WebDriver driver;

	@Test
	public void main() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get(Constante.URL);

		Actions act = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		TelaDeLogin.Execute(driver);

		Cadastro.tx_Usuario(driver).sendKeys("MiguelBR");
		Cadastro.tx_email(driver).sendKeys("migul@email.com");

		Cadastro.tx_senha(driver).sendKeys("96Miguel.");
		Cadastro.tx_confirSenha(driver).sendKeys("96Miguel.");

		Cadastro.tx_PrimeiroNome(driver).sendKeys("Miguel");
		Cadastro.tx_UltimoNome(driver).sendKeys("Bruno");
		Cadastro.tx_numeroTel(driver).sendKeys("99999999999");

		Cadastro.cbx_Pais(driver);
		Cadastro.tx_Cidade(driver).sendKeys("Taboão da Serra");
		Cadastro.tx_Endereco(driver).sendKeys("Rua tal de tal");
		Cadastro.tx_Estado(driver).sendKeys("São Paulo");
		Cadastro.tx_CEP(driver).sendKeys("11111111");
		Cadastro.chk_Aceite(driver).click();
//		driver.findElement(By.id("register_btnundefined")).click();

	}

}
