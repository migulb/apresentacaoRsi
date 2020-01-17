package br.com.rsinet.HUB_TDD.testenegativo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import br.com.rsinet.HUB_TDD.testenegativo.PageObject.PaginaInicialTesteNegativo;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;

public class BuscaPelaPaginaInicialNegativo {

	private WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeMethod
	public void InicioDoTeste() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TestePaginaInicialNegativo.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("TesteCadastroNegativo");

		driver = AcoesDoNavegador.inicializarDriver();
		logger.log(Status.INFO, "Iniciando Navegador");
		logger.log(Status.PASS, "Chrome Iniciado");

	}

	@Test
	public void BuscadeProduto() {
		PaginaInicialTesteNegativo.btn_notebook(driver).click();
		String notebook = driver.findElement(By.xpath("//p[@name='popular_item_10_name']")).getText();
		System.out.println("Estou clicando no: " + notebook);
		String produtoEscolhido = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']"))
				.getText();
		System.out.println("Estou indo para a Página do notebook: " + produtoEscolhido);
		Assert.assertNotEquals(notebook, produtoEscolhido);

		logger.log(Status.INFO, "Busca");
		logger.log(Status.PASS, "Busca incorreta concluída");
	}

	@AfterMethod
	public void EncerraNavegador(ITestResult result) throws IOException {
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
