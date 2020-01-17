package br.com.rsinet.HUB_TDD;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import br.com.rsinet.HUB_TDD.pageObject.RealizaCadastro;
import br.com.rsinet.HUB_TDD.utility.AbraChrome;
import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class CadastrarUsuario {

	WebElement element;
	WebDriver driver;

	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeMethod
	public void AbrirNavegador() throws InterruptedException {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TesteCadastro.html");

		// Função que inicializa as funções de Report

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("TesteCadastro");

		// Inicializa o navegador
		driver = AbraChrome.inicializarDriver();
		logger.log(Status.INFO, "Iniciando Navegador");
		logger.log(Status.PASS, "Chrome Iniciado");
	}

	@Test()
	public void AbrirMenuCadastro() throws Exception {
		// Realiza o cadastro
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");
		RealizaCadastro.Cadastro(driver);
		System.out.println("2: Cadastro realizado com Sucesso");
		logger.log(Status.INFO, "Iniciando Cadastro");
		logger.log(Status.PASS, "Cadastro realizado");

	}

	@AfterMethod
	public void finalizacao(ITestResult result) throws IOException {

		// Monta o Report e fecha o navegador
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
