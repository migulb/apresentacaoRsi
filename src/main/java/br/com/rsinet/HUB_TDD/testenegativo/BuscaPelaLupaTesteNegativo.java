package br.com.rsinet.HUB_TDD.testenegativo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import br.com.rsinet.HUB_TDD.buscaLupa.pageObject.CaminhoDeBuscaPelaLupa;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;
import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class BuscaPelaLupaTesteNegativo {

	private WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeMethod
	public void AbrirNavegador() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TesteBuscaLupaNegativo.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("TesteCadastroNegativo");

		driver = AcoesDoNavegador.inicializarDriver();
		logger.log(Status.INFO, "Iniciando Navegador");
		logger.log(Status.PASS, "Chrome Iniciado");
	}

	@Test()
	public void ProcurarItem() throws Exception {
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha2");
		CaminhoDeBuscaPelaLupa.bt_Procura(driver).click();
		CaminhoDeBuscaPelaLupa.txt_nomeBusca(driver).click();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		CaminhoDeBuscaPelaLupa.txt_nomeBusca(driver)
				.sendKeys(ExcelUtil.getCellData(2, Constante.Col_buscaerro) + Keys.ENTER);

		String url = driver.findElement(By.xpath("//span[contains(text(),'No results for \"Mesa\"')]")).getText();
		Assert.assertEquals(url, "No results for \"Mesa\"");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,-250)", "");

		logger.log(Status.INFO, "Iniciando busca");
		logger.log(Status.PASS, "Busca de Produto Realizada com Sucesso");

	}

	@AfterMethod
	public void UsoAssert(ITestResult result) throws Exception {

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
		AcoesDoNavegador.fecharDriver();
	}
}
