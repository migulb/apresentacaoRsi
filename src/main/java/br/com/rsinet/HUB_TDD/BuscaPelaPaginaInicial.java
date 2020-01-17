package br.com.rsinet.HUB_TDD;

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
import br.com.rsinet.HUB_TDD.buscaprodutopag.pageObject.PesquisarProduto;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;

public class BuscaPelaPaginaInicial {

	private WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeMethod
	public void AbriNavegador() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TestePesquisa.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("TesteCadastro");

		driver = AcoesDoNavegador.inicializarDriver();
		logger.log(Status.INFO, "Iniciando Navegador");
		logger.log(Status.PASS, "Chrome Iniciado");
	}

	@Test()
	public void EscolherProduto() throws Exception {

		PesquisarProduto.Execute(driver);
		logger.log(Status.INFO, "Iniciando busca por Produto");
		logger.log(Status.PASS, "Busca realizada com Sucesso");
	}

	@AfterMethod
	public void fecharNavegador(ITestResult result) throws IOException {
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
