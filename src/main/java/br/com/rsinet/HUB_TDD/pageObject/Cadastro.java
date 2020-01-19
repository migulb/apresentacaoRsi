package br.com.rsinet.HUB_TDD.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
}
