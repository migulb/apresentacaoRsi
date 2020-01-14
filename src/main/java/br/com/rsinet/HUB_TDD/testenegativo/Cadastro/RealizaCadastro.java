package br.com.rsinet.HUB_TDD.testenegativo.Cadastro;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.Constante;
import br.com.rsinet.HUB_TDD.pageObject.Cadastro;
import br.com.rsinet.HUB_TDD.pageObject.TelaDeLogin;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class RealizaCadastro {

	public static void Cadastro(WebDriver driver) throws Exception {

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

//		Cadastro.bt_ConfirmaCadastro(driver).click();

		String User = driver.getPageSource();
		String falha = "Use 4 Character or longer";

		// Assert.assertEquals("Erro ao Cadastrar", falha, User.contains(sUserName));

	}
}
