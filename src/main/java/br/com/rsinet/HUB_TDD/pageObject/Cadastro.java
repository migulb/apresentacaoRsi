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

//Nessa classe eu retorno os elementos com sua devida localização//
public class Cadastro {

	private static WebElement element = null;
	private WebDriver driver;
	
	public Cadastro(WebDriver driver) {
		this.driver = driver;
	}
	

	private static WebElement tx_Usuario(WebDriver driver) {

		return driver.findElement(By.name("usernameRegisterPage"));
	}

	private static WebElement tx_email(WebDriver driver) {

		return driver.findElement(By.name("emailRegisterPage"));
	}

	private static WebElement tx_senha(WebDriver driver) {

		return driver.findElement(By.name("passwordRegisterPage"));
	}

	private static WebElement tx_confirSenha(WebDriver driver) {

		return driver.findElement(By.name("confirm_passwordRegisterPage"));
	}

	private static WebElement tx_PrimeiroNome(WebDriver driver) {

		return driver.findElement(By.name("first_nameRegisterPage"));
	}

	private static WebElement tx_UltimoNome(WebDriver driver) {

		return driver.findElement(By.name("last_nameRegisterPage"));
	}

	private static WebElement tx_numeroTel(WebDriver driver) {

		return driver.findElement(By.name("phone_numberRegisterPage"));
	}

	private static WebElement cbx_Pais(WebDriver driver) {

		return  driver.findElement(By.name("countryListboxRegisterPage"));
	}

	private static WebElement tx_Cidade(WebDriver driver) {

		return  driver.findElement(By.name("cityRegisterPage"));
	}

	private static WebElement tx_Endereco(WebDriver driver) {

		return driver.findElement(By.name("addressRegisterPage"));
	}

	private static WebElement tx_Estado(WebDriver driver) {

		return driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
	}

	private static WebElement tx_CEP(WebDriver driver) {

		return driver.findElement(By.name("postal_codeRegisterPage"));
	}

	private static WebElement chk_Aceite(WebDriver driver) {

		return driver.findElement(By.name("i_agree"));
	}

	private static WebElement bt_ConfirmaCadastro(WebDriver driver) {

		return driver.findElement(By.id("register_btnundefined"));
	}

	public void digitar_usuario(String usuario) {
		tx_Usuario(driver).sendKeys(usuario);
	}
	
	public void digitar_email(String email) {
		tx_email(driver).sendKeys(email);
	}
	
	public void digitar_senha(String senha) {
		tx_senha(driver).sendKeys(senha);
	}
	
	public void confirmar_senha(String confSenha) {
		tx_confirSenha(driver).sendKeys(confSenha);
	}
	public void digitar_Nome(String nome) {
		tx_PrimeiroNome(driver).sendKeys(nome);
	}

	public void digitar_UltimoNome(String endName) {
		tx_UltimoNome(driver).sendKeys(endName);
	}
	
	public void digitar_Telefone(String telefone) {
		tx_numeroTel(driver).sendKeys(telefone);
	}
	
	public void escolher_Pais() throws InterruptedException {
		cbx_Pais(driver).click();
		Thread.sleep(2000);
		new Select(cbx_Pais(driver)).selectByVisibleText("Brazil");
	}
	
	public void digitar_Estado(String estado) {
		tx_Estado(driver).sendKeys(estado);
	}
	
	public void digitar_Endereco(String endereco) {
		tx_Endereco(driver).sendKeys(endereco);
	}
	
	public void digitar_Cidade(String cidade) {
		tx_Cidade(driver).sendKeys(cidade);
	}
	
	public void digitar_CEP(String cep) {
		tx_CEP(driver).sendKeys(cep);
	}
	
	public void confirmaTermos() {
		chk_Aceite(driver).click();
	}
	
	public void confirmarCadastro() {
		bt_ConfirmaCadastro(driver).click();
	}
}
