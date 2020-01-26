package br.com.rsinet.HUB_TDD.testenegativo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import br.com.rsinet.HUB_TDD.buscaLupa.pageObject.CaminhoDeBuscaPelaLupa;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;
import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class BuscaPelaLupaTesteNegativo {

	private WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeTest
	public void IniciaReport() {
		extent = Reports.setExtent("BuscaPelaLupaTesteNegativo_Report");

	}

	@BeforeMethod
	public void AbrirNavegador() {
		logger = Reports.createTest("Teste de Busca pela Lupa Teste Negativo");
		driver = AcoesDoNavegador.inicializarDriver();
	}

	@Test()
	public void ProcurarItem() throws Exception {
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha2");
		CaminhoDeBuscaPelaLupa.bt_Procura(driver).click();
		CaminhoDeBuscaPelaLupa.txt_nomeBusca(driver).click();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		CaminhoDeBuscaPelaLupa.txt_nomeBusca(driver)
				.sendKeys(ExcelUtil.getCellData(2, Constante.Col_buscaerro) + Keys.ENTER);

		// O xpath ficou exposto na pagina, pois tive problemas para encapsola-lo//
		String url = driver.findElement(By.xpath("//span[contains(text(),'No results for \"Mesa\"')]")).getText();
		Assert.assertEquals(url, "No results for \"Mesa\"");

//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("scrollBy(0,-250)", "");

	}

	@AfterMethod
	public void UsoAssert(ITestResult result) throws Exception {

		// Monta o Report e fecha o navegador
		Reports.statusReported(logger, result, driver);
		Reports.quitExtent(extent);
		AcoesDoNavegador.fecharDriver();
	}
}
