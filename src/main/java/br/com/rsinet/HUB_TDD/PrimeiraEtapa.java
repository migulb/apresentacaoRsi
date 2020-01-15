package br.com.rsinet.HUB_TDD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.HUB_TDD.Report.Utility;
import br.com.rsinet.HUB_TDD.pageObject.RealizaCadastro;
import br.com.rsinet.HUB_TDD.pageObject.TelaDeLogin;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class PrimeiraEtapa {

	WebElement element;
	private static WebDriver driver;

	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeMethod
	public void AbrirNavegador() throws InterruptedException {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/TesteCadastro.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("TesteCadastro");

		driver = new ChromeDriver();
		driver.get(Constante.URL);
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Navegador Aberto e página inicializada");
	}

	@Test
	public void AbrirMenuCadastro() throws Exception {
		TelaDeLogin.Execute(driver);
		System.out.println("1: Menu aberto e encaminhando ao formulário de cadastro");
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");
		RealizaCadastro.Cadastro(driver);
		System.out.println("2: Cadastro realizado com Sucesso");

	}

	@AfterMethod
	public void finalizacao(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Utility.getScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String temp = Utility.getScreenshot(driver);
			logger.pass("Cadastro com Sucesso !", MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build());
		}
		extent.flush();
		driver.quit();
	}
}
