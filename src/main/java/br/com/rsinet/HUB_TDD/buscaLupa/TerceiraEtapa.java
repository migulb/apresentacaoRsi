package br.com.rsinet.HUB_TDD.buscaLupa;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.HUB_TDD.Constante;
import br.com.rsinet.HUB_TDD.buscaLupa.pageObject.CaminhoBusca;
import br.com.rsinet.HUB_TDD.utility.ExcelUtil;

public class TerceiraEtapa {

	private WebDriver driver;

	@Test
	public void main() throws Exception {

		ExcelUtil.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha2");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constante.URL);
		String busca = ExcelUtil.getCellData(1, 1);

		CaminhoBusca.bt_Procura(driver).click();
		CaminhoBusca.txt_nomeBusca(driver).click();
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
		CaminhoBusca.txt_nomeBusca(driver).sendKeys(busca + Keys.ENTER);
//		driver.findElement(By.xpath("//*[@id=\'output\']/div/div[2]/a[2]/img")).click();

	}

}
