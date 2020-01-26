package br.com.rsinet.HUB_TDD;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.Report.Reports;
import br.com.rsinet.HUB_TDD.buscaprodutopag.pageObject.PesquisarProduto;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;

public class BuscaPelaPaginaInicial {

	private WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeTest
	public void IniciaReport() {
		extent = Reports.setExtent("PaginaInicial_Report");

	}

	@BeforeMethod
	public void AbriNavegador() {
		logger = Reports.createTest("Teste de Busca da Pagina Inicial");

		driver = AcoesDoNavegador.inicializarDriver();

	}

	@Test()
	public void EscolherProduto() throws Exception {

		PesquisarProduto.Execute(driver);

	}

	@AfterMethod
	public void fecharNavegador(ITestResult result) throws IOException {

		Reports.statusReported(logger, result, driver);
		Reports.quitExtent(extent);
		driver.quit();
	}
}
