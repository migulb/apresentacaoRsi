package br.com.rsinet.HUB_TDD.testenegativo.Cadastro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.Constante;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class PrimeiraEtapaNegativa {

	private WebDriver driver;

	@Test(priority = 0)
	public void AbrirNavegador() {
		driver = new ChromeDriver();
		driver.get(Constante.URL);
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void RealizarCadastro() throws Exception {

		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");

		RealizaCadastro.Cadastro(driver);

	}

	@Test(priority = 2)
	public void FecharNavegador() {

		driver.quit();
	}
}
