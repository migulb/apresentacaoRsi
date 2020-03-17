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
import org.testng.annotations.AfterTest;
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

	private static WebElement element;
	private static WebDriver driver;
	private static DadosExcel dados;
	private static Home_Page home;
	private static Cadastro cadastro;
	
	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeTest
	public void IniciaReport() {
		extent = Reports.setExtent("Cadastro_Report");

	}

	@BeforeMethod
	public void AbrirNavegador() throws Exception {
		// Inicializa o navegador
		driver = AcoesDoNavegador.inicializarDriver();
		dados = new DadosExcel(driver);
		home = new Home_Page(driver);
		cadastro = new Cadastro(driver);
	}

	@Test
	public void Cadastro1() throws Exception {
		logger = Reports.createTest("TesteCadastroUsuario");
		// Realiza o cadastro

		home.clickar_login();
		home.clickar_Cadastro();
		cadastro.digitar_usuario(dados.usuario());
		cadastro.digitar_email(dados.email());
		cadastro.digitar_senha(dados.senha());
		cadastro.confirmar_senha(dados.ConfirmaSenha());
		cadastro.digitar_Nome(dados.PrimeiroNome());
		cadastro.digitar_UltimoNome(dados.UltimoNome());
		cadastro.digitar_Telefone(dados.Telefone());
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
	
	@Test
	public void Cadastro2() throws Exception {
		logger = Reports.createTest("TesteCadastroUsuarioNegativo");
		
		home.clickar_login();
		home.clickar_Cadastro();
		cadastro.digitar_usuario(dados.usuario_falha());
		cadastro.digitar_email(dados.email_falha());
		cadastro.digitar_senha(dados.senha_falha());
		cadastro.confirmar_senha(dados.ConfirmaSenha_falha());
		cadastro.digitar_Nome(dados.PrimeiroNome_falha());
		cadastro.digitar_UltimoNome(dados.UltimoNome_falha());
		cadastro.digitar_Telefone(dados.Telefone_falha());
		cadastro.escolher_Pais();
		cadastro.digitar_Cidade(dados.Cidade_falha());
		cadastro.digitar_Endereco(dados.Endereco_falha());
		cadastro.digitar_Estado(dados.Estado_falha());
		cadastro.digitar_CEP(dados.CEP_falha());
		cadastro.confirmaTermos();
		cadastro.confirmarCadastro();
		
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		String User = driver.getPageSource();
		String falha = "One upper letter required";

		Assert.assertTrue(User.contains(falha));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,-400)", "");
	}

	@AfterMethod
	public void finalizacao(ITestResult result) throws IOException {
		Reports.statusReported(logger, result, driver);
		AcoesDoNavegador.fecharDriver();
	}
	
	@AfterTest
	public void finalizaReport() {
		Reports.quitExtent(extent);

	}
	
}
