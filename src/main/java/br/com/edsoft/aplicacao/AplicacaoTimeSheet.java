package br.com.edsoft.aplicacao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.edsoft.contexto.ContextoPortalTimeSheet;


public class AplicacaoTimeSheet {

	public static WebDriver createChrome() {
//		getDriver().get("C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		ContextoPortalTimeSheet portal = new ContextoPortalTimeSheet();
		portal.URL(driver);
		return driver;
	}

}
