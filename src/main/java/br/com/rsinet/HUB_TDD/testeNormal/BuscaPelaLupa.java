package br.com.rsinet.HUB_TDD.testeNormal;

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
import br.com.rsinet.HUB_TDD.buscaLupa.pageObject.ProcurarProduto;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;
import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class BuscaPelaLupa {

	private WebDriver driver;
	private static ExtentTest logger;
	private static ExtentReports extent;

	@BeforeTest
	public void IniciaReport() {
		extent = Reports.setExtent("BuscaPelaLupa_Report");

	}

	@BeforeMethod
	public void AbrirNavegador() {
		logger = Reports.createTest("Teste de Busca pela Lupa");

		driver = AcoesDoNavegador.inicializarDriver();

	}

	@Test()
	public void ProcurarItem() throws Exception {
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha2");

		ProcurarProduto.Execute(driver);
	}

	@AfterMethod
	public void FecharNavegador(ITestResult result) throws IOException {

		Reports.statusReported(logger, result, driver);
		Reports.quitExtent(extent);
		driver.quit();
	}
}
