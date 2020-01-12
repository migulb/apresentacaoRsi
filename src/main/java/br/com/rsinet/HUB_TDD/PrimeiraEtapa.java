package br.com.rsinet.HUB_TDD;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.rsinet.HUB_TDD.pageObject.Cadastro;
import br.com.rsinet.HUB_TDD.pageObject.TelaDeLogin;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class PrimeiraEtapa {

	private WebDriver driver;

	@Test
	public void main() throws Exception {
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");

		driver = new ChromeDriver();
		driver.get(Constante.URL);

		String sUserName = ExcelUtil.getCellData(1, 1);
		String email = ExcelUtil.getCellData(1, 2);
		String senha = ExcelUtil.getCellData(1, 3);
		String confSenha = ExcelUtil.getCellData(1, 4);
		String Nome = ExcelUtil.getCellData(1, 5);

		Actions act = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		TelaDeLogin.Execute(driver);

		Cadastro.tx_Usuario(driver).sendKeys(sUserName);
		Cadastro.tx_email(driver).sendKeys(email);

		Cadastro.tx_senha(driver).sendKeys(senha);
		Cadastro.tx_confirSenha(driver).sendKeys(confSenha);

		Cadastro.tx_PrimeiroNome(driver).sendKeys(Nome);
//		Cadastro.tx_UltimoNome(driver).sendKeys("Bruno");
//		Cadastro.tx_numeroTel(driver).sendKeys("99999999999");
//
//		Cadastro.cbx_Pais(driver);
//		Cadastro.tx_Cidade(driver).sendKeys("Taboão da Serra");
//		Cadastro.tx_Endereco(driver).sendKeys("Rua tal de tal");
//		Cadastro.tx_Estado(driver).sendKeys("São Paulo");
//		Cadastro.tx_CEP(driver).sendKeys("11111111");
//		Cadastro.chk_Aceite(driver).click();
//		driver.findElement(By.id("register_btnundefined")).click();

	}

}
