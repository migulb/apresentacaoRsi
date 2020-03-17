package br.com.rsinet.HUB_TDD.testeNormal;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.Report.Reports;
import br.com.rsinet.HUB_TDD.buscaLupa.pageObject.CaminhoDeBuscaPelaLupa;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;
import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.DadosExcel;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class BuscaPelaLupa {

	private static WebDriver driver;
	private static ExtentTest logger;
	private static ExtentReports extent;
	private static CaminhoDeBuscaPelaLupa lupa;
	private static DadosExcel dados;

	@BeforeTest
	public void IniciaReport() throws Exception {
		extent = Reports.setExtent("BuscaPelaLupa_Report");
	}

	@BeforeMethod
	public void AbrirNavegador() throws Exception {
		driver = AcoesDoNavegador.inicializarDriver();
		lupa = new CaminhoDeBuscaPelaLupa(driver);
		dados = new DadosExcel(driver);

	}

	@Test()
	public void ProcurarItem1() throws Exception {
		logger = Reports.createTest("Teste de Busca pela Lupa positivo");
		lupa.clicar_Lupa();
		lupa.digitar_Produto(dados.Busca_lupa() + Keys.ENTER);
		lupa.clica_produto();
		lupa.clicka_Carrinho();
		lupa.finaliza_Compra();
		
		String busca = driver.getPageSource();
		String produto = "HP Z4000 WIRELESS MOUSE";
		Assert.assertTrue(busca.contains(produto));
	}
	
	@Test()
	public void ProcurarItem2() throws Exception {
		logger = Reports.createTest("Teste de Busca pela Lupa Negativo");
		lupa.clicar_Lupa();
		lupa.digitar_Produto(dados.Busca_falha() + Keys.ENTER);
		String url = driver.findElement(By.xpath("//span[contains(text(),'No results for \"Mesa\"')]")).getText();
		Assert.assertEquals(url, "No results for \"Mesa\"");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
	}

	@AfterMethod
	public void FecharNavegador(ITestResult result) throws IOException {

		Reports.statusReported(logger, result, driver);
		AcoesDoNavegador.fecharDriver();
	}
	
	@AfterTest
	public void finalizaReport() {
		
		Reports.quitExtent(extent);	
	}
}
