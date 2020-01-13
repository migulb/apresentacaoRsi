package br.com.rsinet.HUB_TDD.testenegativo;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.Constante;
import br.com.rsinet.HUB_TDD.pageObject.Cadastro;
import br.com.rsinet.HUB_TDD.pageObject.TelaDeLogin;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;
import junit.framework.Assert;

public class RealizaCadastro {

	public static void Cadastro(WebDriver driver) throws Exception {

		TelaDeLogin.Execute(driver);

		String sUserName = ExcelUtil.getCellData(1, Constante.Col_UserName);
		Cadastro.tx_Usuario(driver).sendKeys(sUserName);

		String email = ExcelUtil.getCellData(1, Constante.Col_email);
		Cadastro.tx_email(driver).sendKeys(email);

		String senha = ExcelUtil.getCellData(1, Constante.Col_senha);
		Cadastro.tx_senha(driver).sendKeys(senha);

		String confSenha = ExcelUtil.getCellData(1, Constante.Col_confSenha);
		Cadastro.tx_confirSenha(driver).sendKeys(confSenha);

		String Nome = ExcelUtil.getCellData(1, Constante.Col_Nome);
		Cadastro.tx_PrimeiroNome(driver).sendKeys(Nome);

		String endName = ExcelUtil.getCellData(1, Constante.Col_endName);
		Cadastro.tx_UltimoNome(driver).sendKeys(endName);

		String numTel = ExcelUtil.getCellData(1, Constante.Col_Tel);
		Cadastro.tx_numeroTel(driver).sendKeys(numTel);

		Cadastro.cbx_Pais(driver);

		String cidade = ExcelUtil.getCellData(1, Constante.Col_cidade);
		Cadastro.tx_Cidade(driver).sendKeys(cidade);

		String endereco = ExcelUtil.getCellData(1, Constante.Col_endereco);
		Cadastro.tx_Endereco(driver).sendKeys(endereco);

		String estado = ExcelUtil.getCellData(1, Constante.Col_estado);
		Cadastro.tx_Estado(driver).sendKeys(estado);

		String cep = ExcelUtil.getCellData(1, Constante.COl_cep);
		Cadastro.tx_CEP(driver).sendKeys(cep);

		Cadastro.chk_Aceite(driver).click();

		Cadastro.bt_ConfirmaCadastro(driver).click();

		String User = driver.getPageSource();
		String falha = "Use 4 Character or longer";

		Assert.assertEquals("Erro ao Cadastrar", falha, User.contains(sUserName));

	}
}
