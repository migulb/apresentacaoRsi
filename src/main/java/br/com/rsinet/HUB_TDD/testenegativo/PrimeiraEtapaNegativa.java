package br.com.rsinet.HUB_TDD.testenegativo;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.HUB_TDD.Constante;
import br.com.rsinet.HUB_TDD.pageObject.RealizaCadastro;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class PrimeiraEtapaNegativa {

	private WebDriver driver;

	@Test
	public void main() throws Exception {
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");

		driver = new ChromeDriver();
		driver.get(Constante.URL);

		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		RealizaCadastro.Cadastro(driver);

	}
}
