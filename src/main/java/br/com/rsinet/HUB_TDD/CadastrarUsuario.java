package br.com.rsinet.HUB_TDD;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CadastrarUsuario {

	WebElement element;
	WebDriver driver;

	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeTest
	public void IniciaReport() {
		extent = Reports.setExtent("Cadastro_Report");

	}

	@BeforeMethod
	public void AbrirNavegador() throws InterruptedException {

		// Função que inicializa as funções de Report
		logger = Reports.createTest("TesteCadastroUsuario");

		// Inicializa o navegador
		driver = AcoesDoNavegador.inicializarDriver();
	}

	@Test()
	public void AbrirMenuCadastro() throws Exception {
		// Realiza o cadastro

		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");
		Cadastro.FuncaoCadastro(driver);
		System.out.println("2: Cadastro realizado com Sucesso");

	}

	@AfterMethod
	public void finalizacao(ITestResult result) throws IOException {

		Reports.statusReported(logger, result, driver);
		Reports.quitExtent(extent);
		driver.quit();
	}
}
