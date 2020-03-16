package br.com.rsinet.HUB_TDD.testeNormal;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.Report.Reports;
import br.com.rsinet.HUB_TDD.pageObject.Cadastro;
import br.com.rsinet.HUB_TDD.pageObject.Home_Page;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;
import br.com.rsinet.HUB_TDD.utility.DadosExcel;

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
		DadosExcel dados = new DadosExcel(driver);
		Home_Page home = new Home_Page(driver);
		Cadastro cadastro = new Cadastro(driver);

		home.clickar_login();
		home.clickar_Cadastro();
		cadastro.digitar_usuario(dados.usuario());
		cadastro.digitar_email(dados.email());
		cadastro.digitar_senha(dados.senha());
		cadastro.confirmar_senha(dados.ConfirmaSenha());
		cadastro.digitar_Nome(dados.PrimeiroNome());
		cadastro.digitar_UltimoNome(dados.UltimoNome());
		cadastro.digitar_Telefone(dados.Telefone());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,320)", "");
		cadastro.escolher_Pais();
		cadastro.digitar_Cidade(dados.Cidade());
		cadastro.digitar_Endereco(dados.Endereco());
		cadastro.digitar_Estado(dados.Estado());
		cadastro.digitar_CEP(dados.CEP());
		cadastro.confirmaTermos();
		cadastro.confirmarCadastro();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String user = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")).getText();

		Assert.assertTrue(user.contains(dados.usuario()), "Usuário encontrado");
	}

	@AfterMethod
	public void finalizacao(ITestResult result) throws IOException {

		Reports.statusReported(logger, result, driver);
		Reports.quitExtent(extent);
		driver.quit();
	}
}
