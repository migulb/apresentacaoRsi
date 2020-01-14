package br.com.rsinet.HUB_TDD;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.pageObject.RealizaCadastro;
import br.com.rsinet.HUB_TDD.pageObject.TelaDeLogin;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class PrimeiraEtapa {

	WebElement element;
	private WebDriver driver;

	@Test(priority = 0)
	public void AbrirNavegador() throws InterruptedException {

		DOMConfigurator.configure("log4j.xml");

		driver = new ChromeDriver();

		driver.get(Constante.URL);

		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		System.out.println("Navegador Aberto e página inicializada");
	}

	@Test(priority = 1)
	public void AbrirMenuCadastro() throws InterruptedException {
		TelaDeLogin.Execute(driver);
		System.out.println("1: Menu aberto e encaminhando ao formulário de cadastro");
	}

	@Test(priority = 2)
	public void RealizarCadastro() throws Exception {
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");
		RealizaCadastro.Cadastro(driver);
		System.out.println("2: Cadastro realizado com Sucesso");
	}

	@Test(priority = 3)
	public void FecharNavegador() {
		driver.quit();
		System.out.println("3: Navegador Fechando");
	}

}
