package br.com.rsinet.HUB_TDD.Report;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	// Gera o nome do Report a localização que será salvo e seta as informações do
	// mesmo//
	public static ExtentReports setExtent(String nomeReport) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "./Reports/" + nomeReport + ".html");

		htmlReporter.config().setDocumentTitle("Report de Testes");
		htmlReporter.config().setReportName("Report TDD");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		// Gera Informações dentro do Report//
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester", "Miguel Bruno");
		extent.setSystemInfo("Browser", "Chrome");
		return extent;
	}

	// Inicia o teste(cria o mesmo)
	public static ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	// Pega o resultado e com base nisso gera o result para cada "if"
	public static void statusReported(ExtentTest test, ITestResult result, WebDriver driver) throws IOException {

		String caminhoScreen = GerarScreen.getScreenshot(driver, result.getName());

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Falha ao Realizar Teste: " + result.getName());
			test.log(Status.FAIL, "Falha ao Realizar Teste: " + result.getThrowable());

			test.addScreenCaptureFromPath(caminhoScreen);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Caso de teste Pulado: " + result.getName());
			test.addScreenCaptureFromPath(caminhoScreen);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Sucesso no caso de Teste: " + result.getName());
			test.addScreenCaptureFromPath(caminhoScreen);
		}
	}

	// finaliza o teste
	public static void quitExtent(ExtentReports extent) {
		extent.flush();
	}
}
