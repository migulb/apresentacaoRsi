package br.com.rsinet.HUB_TDD.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class Cadastro {
	private static WebElement element = null;

	public static WebElement tx_Usuario(WebDriver driver) {

		element = driver.findElement(By.name("usernameRegisterPage"));

		return element;
	}

	public static WebElement tx_email(WebDriver driver) {

		element = driver.findElement(By.name("emailRegisterPage"));

		return element;
	}

	public static WebElement tx_senha(WebDriver driver) {

		element = driver.findElement(By.name("passwordRegisterPage"));

		return element;
	}

	public static WebElement tx_confirSenha(WebDriver driver) {

		element = driver.findElement(By.name("confirm_passwordRegisterPage"));

		return element;
	}

	public static WebElement tx_PrimeiroNome(WebDriver driver) {

		element = driver.findElement(By.name("first_nameRegisterPage"));

		return element;
	}

	public static WebElement tx_UltimoNome(WebDriver driver) {

		element = driver.findElement(By.name("last_nameRegisterPage"));

		return element;
	}

	public static WebElement tx_numeroTel(WebDriver driver) {

		element = driver.findElement(By.name("phone_numberRegisterPage"));

		return element;
	}

	public static WebElement cbx_Pais(WebDriver driver) {

		WebElement element = driver.findElement(By.name("countryListboxRegisterPage"));
		new Select(element).selectByVisibleText("Brazil");

		return element;
	}

	public static WebElement tx_Cidade(WebDriver driver) {

		element = driver.findElement(By.name("cityRegisterPage"));

		return element;
	}

	public static WebElement tx_Endereco(WebDriver driver) {

		element = driver.findElement(By.name("addressRegisterPage"));

		return element;
	}

	public static WebElement tx_Estado(WebDriver driver) {

		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));

		return element;
	}

	public static WebElement tx_CEP(WebDriver driver) {

		element = driver.findElement(By.name("postal_codeRegisterPage"));

		return element;
	}

	public static WebElement chk_Aceite(WebDriver driver) {

		element = driver.findElement(By.name("i_agree"));

		return element;
	}

	public static WebElement bt_ConfirmaCadastro(WebDriver driver) {

		element = driver.findElement(By.id("register_btnundefined"));

		return element;
	}

	public static void FuncaoCadastro(WebDriver driver) throws Exception {

		TelaDeLogin.Execute(driver);

		String sUserName = ExcelUtil.getCellData(1, Constante.Col_UserName);
		Cadastro.tx_Usuario(driver).sendKeys(sUserName);

		Cadastro.tx_email(driver).sendKeys(ExcelUtil.getCellData(1, Constante.Col_email));

		Cadastro.tx_senha(driver).sendKeys(ExcelUtil.getCellData(1, Constante.Col_senha));

		Cadastro.tx_confirSenha(driver).sendKeys(ExcelUtil.getCellData(1, Constante.Col_confSenha));

		Cadastro.tx_PrimeiroNome(driver).sendKeys(ExcelUtil.getCellData(1, Constante.Col_Nome));

		Cadastro.tx_UltimoNome(driver).sendKeys(ExcelUtil.getCellData(1, Constante.Col_endName));

		Cadastro.tx_numeroTel(driver).sendKeys(ExcelUtil.getCellData(1, Constante.Col_Tel));

		Cadastro.cbx_Pais(driver);

		Cadastro.tx_Cidade(driver).sendKeys(ExcelUtil.getCellData(1, Constante.Col_cidade));

		Cadastro.tx_Endereco(driver).sendKeys(ExcelUtil.getCellData(1, Constante.Col_endereco));

		Cadastro.tx_Estado(driver).sendKeys(ExcelUtil.getCellData(1, Constante.Col_estado));

		Cadastro.tx_CEP(driver).sendKeys(ExcelUtil.getCellData(1, Constante.COl_cep));

		Cadastro.chk_Aceite(driver).click();

		Cadastro.bt_ConfirmaCadastro(driver).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String user = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")).getText();

		Assert.assertTrue(user.contains(sUserName), "Usuário encontrado");

	}

	public static void FuncaoCadastroTesteNegativo(WebDriver driver) throws Exception {

		TelaDeLogin.Execute(driver);

		String sUserName = ExcelUtil.getCellData(2, Constante.Col_UserName);
		Cadastro.tx_Usuario(driver).sendKeys(sUserName);

		Cadastro.tx_email(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_email));

		Cadastro.tx_senha(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_senha));

		Cadastro.tx_confirSenha(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_confSenha));

		Cadastro.tx_PrimeiroNome(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_Nome));

		Cadastro.tx_UltimoNome(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_endName));

		Cadastro.tx_numeroTel(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_Tel));

		Cadastro.cbx_Pais(driver);

		Cadastro.tx_Cidade(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_cidade));

		Cadastro.tx_Endereco(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_endereco));

		Cadastro.tx_Estado(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_estado));

		Cadastro.tx_CEP(driver).sendKeys(ExcelUtil.getCellData(2, Constante.COl_cep));

		Cadastro.chk_Aceite(driver).click();

		Cadastro.bt_ConfirmaCadastro(driver).click();

		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		String User = driver.getPageSource();
		String falha = "One upper letter required";

		Assert.assertTrue(User.contains(falha));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,-400)", "");

	}

}
