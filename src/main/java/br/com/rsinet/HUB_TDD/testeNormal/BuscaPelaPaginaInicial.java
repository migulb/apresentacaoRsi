package br.com.rsinet.HUB_TDD.testeNormal;

import java.io.IOException;

import org.openqa.selenium.By;
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
import br.com.rsinet.HUB_TDD.buscaprodutopag.pageObject.BuscaProduto;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;

public class BuscaPelaPaginaInicial {

	private WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest logger;
	private static BuscaProduto busca;

	@BeforeTest
	public void IniciaReport() {
		extent = Reports.setExtent("PaginaInicial_Report");

	}

	@BeforeMethod
	public void AbriNavegador() {
		driver = AcoesDoNavegador.inicializarDriver();
		busca = new BuscaProduto(driver);
	}

	@Test()
	public void EscolherProduto() throws Exception {
		logger = Reports.createTest("Teste de Busca da Pagina Inicial");
		busca.click_categoria();
		busca.click_MouseEspecifico();
		busca.adiciona_carrinho();
		busca.carrinho();

		String busca = driver.getPageSource();

		Assert.assertTrue(busca.contains("/catalog/fetchImage?image_id=5200"));

	}
	
	@Test()
	public void EscolherProduto2() {
		logger = Reports.createTest("Teste negativo de Busca da Pagina Inicial");
		busca.clicka_Notebook();
		String notebook = driver.findElement(By.xpath("//p[@name='popular_item_10_name']")).getText();
		System.out.println("Estou clicando no: " + notebook);
		String produtoEscolhido = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']")).getText();
		System.out.println("Estou indo para a Página do notebook: " + produtoEscolhido);
		Assert.assertNotEquals(notebook, produtoEscolhido);
	}

	@AfterMethod
	public void fecharNavegador(ITestResult result) throws IOException {
		Reports.statusReported(logger, result, driver);
		AcoesDoNavegador.fecharDriver();
	}
	
	@AfterTest
	public void finalizaReport() {
		Reports.quitExtent(extent);
	}
}
