package br.com.rsinet.HUB_TDD.testenegativo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.Report.Reports;
import br.com.rsinet.HUB_TDD.testenegativo.PageObject.PaginaInicialTesteNegativo;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;

public class BuscaPelaPaginaInicialNegativo {

	private WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeTest
	public void IniciaReport() {
		extent = Reports.setExtent("TesteNegativoPaginaInicial_Report");

	}

	@BeforeMethod
	public void InicioDoTeste() {

		logger = Reports.createTest("Teste Negativo de Busca Pela Tela Inicial");
		driver = AcoesDoNavegador.inicializarDriver();
	}

	@Test
	public void BuscadeProduto() throws InterruptedException {
		PaginaInicialTesteNegativo.btn_notebook(driver).click();
		String notebook = PaginaInicialTesteNegativo.text_noteInicial(driver).getText();
		System.out.println("Estou clicando no: " + notebook);
		String produtoEscolhido = PaginaInicialTesteNegativo.text_noteFinal(driver).getText();
		System.out.println("Estou indo para a Página do notebook: " + produtoEscolhido);
		Assert.assertNotEquals(notebook, produtoEscolhido);
	}

	@AfterMethod
	public void EncerraNavegador(ITestResult result) throws IOException {
		// Monta o Report e fecha o navegador
		Reports.statusReported(logger, result, driver);
		Reports.quitExtent(extent);
		driver.quit();
	}

}
