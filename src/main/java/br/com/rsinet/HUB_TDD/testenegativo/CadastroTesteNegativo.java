package br.com.rsinet.HUB_TDD.testenegativo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
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
import br.com.rsinet.HUB_TDD.pageObject.Cadastro;
import br.com.rsinet.HUB_TDD.pageObject.Home_Page;
import br.com.rsinet.HUB_TDD.utility.AcoesDoNavegador;
import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.DadosExcel;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class CadastroTesteNegativo {

	private WebDriver driver;

	private static ExtentReports extent;
	private static ExtentTest logger;

	@BeforeTest
	public void IniciaReport() {
		extent = Reports.setExtent("CadastroTesteNegativo_Report");

	}

	@BeforeMethod
	public void AbrirNavegador() {

		logger = Reports.createTest("Teste Negativo de Cadastro");

		driver = AcoesDoNavegador.inicializarDriver();

	}

	@Test()
	public void RealizarCadastro() throws Exception {
		DadosExcel dados = new DadosExcel(driver);
		Home_Page home = new Home_Page(driver);
		Cadastro cadastro = new Cadastro(driver);

		home.clickar_login();
		home.clickar_Cadastro();
		cadastro.digitar_usuario(dados.usuario_falha());
		cadastro.digitar_email(dados.email_falha());
		cadastro.digitar_senha(dados.senha_falha());
		cadastro.confirmar_senha(dados.ConfirmaSenha_falha());
		cadastro.digitar_Nome(dados.PrimeiroNome_falha());
		cadastro.digitar_UltimoNome(dados.UltimoNome_falha());
		cadastro.digitar_Telefone(dados.Telefone_falha());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,320)", "");
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

		jse.executeScript("scrollBy(0,-400)", "");
	}

	@AfterMethod
	public void FecharNavegador(ITestResult result) throws IOException {
		Reports.statusReported(logger, result, driver);
		Reports.quitExtent(extent);
		driver.quit();
	}
}
