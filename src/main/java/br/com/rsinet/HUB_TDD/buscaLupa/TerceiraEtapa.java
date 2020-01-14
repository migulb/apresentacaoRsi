package br.com.rsinet.HUB_TDD.buscaLupa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.Constante;
import br.com.rsinet.HUB_TDD.buscaLupa.pageObject.CaminhoBusca;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class TerceiraEtapa {

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
		CaminhoBusca.bt_Procura(driver).click();
		CaminhoBusca.txt_nomeBusca(driver).click();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		CaminhoBusca.txt_nomeBusca(driver).sendKeys(ExcelUtil.getCellData(1, 1) + Keys.ENTER);
//		driver.findElement(By.xpath("//*[@id=\'output\']/div/div[2]/a[2]/img")).click();
	}

	@Test(priority = 2)
	public void FecharNavegador() {

//		driver.quit();

	}
}
