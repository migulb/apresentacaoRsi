package br.com.rsinet.HUB_TDD.testenegativo.buscaLupa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.buscaLupa.pageObject.CaminhoDeBuscaPelaLupa;
import br.com.rsinet.HUB_TDD.utility.Constante;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class TerceiraEtapaNegativo {

	private WebDriver driver;

	@Test(priority = 0)
	public void AbrirNavegador() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constante.URL);
	}

	@Test(priority = 1)
	public void ProcurarItem() throws Exception {
		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha2");
		CaminhoDeBuscaPelaLupa.bt_Procura(driver).click();
		CaminhoDeBuscaPelaLupa.txt_nomeBusca(driver).click();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);

		CaminhoDeBuscaPelaLupa.txt_nomeBusca(driver).sendKeys(ExcelUtil.getCellData(2, Constante.Col_buscaerro) + Keys.ENTER);

	}

	@Test(priority = 2)
	public void UsoAssert() throws Exception {

		String url = driver.findElement(By.xpath("//span[contains(text(),'No results for \"Mesa\"')]")).getText();
		Assert.assertEquals(url, "No results for \"Mesa\"");
	}
}
