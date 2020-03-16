package br.com.rsinet.HUB_TDD.utility;

import org.openqa.selenium.WebDriver;

public class DadosExcel {

	
	private WebDriver driver;

	public DadosExcel(WebDriver driver) throws Exception {
		this.driver = driver;
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, Constante.SheetName);

	}

	public String usuario() throws Exception {

		return ExcelUtil.getCellData(1, Constante.Col_UserName);
	}

	public String email() throws Exception {
		return ExcelUtil.getCellData(1, Constante.Col_email);
	}

	public String senha() throws Exception {
		return ExcelUtil.getCellData(1, Constante.Col_senha);
	}

	public String ConfirmaSenha() throws Exception {
		return ExcelUtil.getCellData(1, Constante.Col_confSenha);

	}

	public String PrimeiroNome() throws Exception {
		return ExcelUtil.getCellData(1, Constante.Col_Nome);

	}

	public String UltimoNome() throws Exception {
		return ExcelUtil.getCellData(1, Constante.Col_endName);
	}

	public String Telefone() throws Exception {
		return ExcelUtil.getCellData(1, Constante.Col_Tel);
	}

	public String Estado() throws Exception {
		return ExcelUtil.getCellData(1, Constante.Col_estado);
	}

	public String Endereco() throws Exception {
		return ExcelUtil.getCellData(1, Constante.Col_endereco);
	}

	public String Cidade() throws Exception {
		return ExcelUtil.getCellData(1, Constante.Col_cidade);
	}

	public String CEP() throws Exception {
		return ExcelUtil.getCellData(1, Constante.COl_cep);
	}
	public String usuario_falha() throws Exception {

		return ExcelUtil.getCellData(2, Constante.Col_UserName);
	}

	public String email_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.Col_email);
	}

	public String senha_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.Col_senha);
	}

	public String ConfirmaSenha_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.Col_confSenha);

	}

	public String PrimeiroNome_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.Col_Nome);

	}

	public String UltimoNome_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.Col_endName);
	}

	public String Telefone_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.Col_Tel);
	}

	public String Estado_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.Col_estado);
	}

	public String Endereco_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.Col_endereco);
	}

	public String Cidade_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.Col_cidade);
	}

	public String CEP_falha() throws Exception {
		return ExcelUtil.getCellData(2, Constante.COl_cep);
	}

}

