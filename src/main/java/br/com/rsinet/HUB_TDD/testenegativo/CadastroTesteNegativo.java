package br.com.rsinet.HUB_TDD.testenegativo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.HUB_TDD.Report.Utility;
import br.com.rsinet.HUB_TDD.testenegativo.PageObject.RealizaCadastroNegativo;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;
import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class CadastroTesteNegativo {

	private WebDriver driver;

	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeMethod
	public void AbrirNavegador() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/CadastroNegativo.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("TesteCadastro");

		driver = AcoesDoNavegador.inicializarDriver();
		logger.log(Status.INFO, "Iniciando Navegador");
		logger.log(Status.PASS, "Chrome Iniciado");
	}

	@Test()
	public void RealizarCadastro() throws Exception {

		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");

		RealizaCadastroNegativo.Cadastro(driver);

		logger.log(Status.INFO, "Iniciando Cadastro");
		logger.log(Status.PASS, "Cadastro não realizado");

	}

	@AfterMethod
	public void FecharNavegador(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Utility.getScreenshot(driver);
			logger.fail("Erro ao realizar Cadastro", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String temp = Utility.getScreenshot(driver);
			logger.pass("Cadastro com Sucesso !", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		logger.log(Status.INFO, "Finalizando Teste");
		logger.log(Status.PASS, "Encerrando Navegador");
		extent.flush();
		driver.quit();
	}
}
