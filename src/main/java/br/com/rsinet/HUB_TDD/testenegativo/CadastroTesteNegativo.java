package br.com.rsinet.HUB_TDD.testenegativo;

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
import br.com.rsinet.HUB_TDD.pageObject.Cadastro;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;
import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class CadastroTesteNegativo {

	private WebDriver driver;

	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeTest
	public void IniciaReport() {
		extent = Reports.setExtent("CadastroTesteNegativo_Report");

	}

	@BeforeMethod
	public void AbrirNavegador() {

		logger = Reports.createTest("Teste Negativo de Cadastro");

		driver = AcoesDoNavegador.inicializarDriver();

	}

	@Test()
	public void RealizarCadastro() throws Exception {

		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");

		Cadastro.FuncaoCadastroTesteNegativo(driver);

	}

	@AfterMethod
	public void FecharNavegador(ITestResult result) throws IOException {
		Reports.statusReported(logger, result, driver);
		Reports.quitExtent(extent);
		driver.quit();
	}
}
