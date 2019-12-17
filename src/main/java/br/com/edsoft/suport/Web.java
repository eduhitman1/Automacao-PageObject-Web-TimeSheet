package br.com.edsoft.suport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Web {

	public static WebDriver createChrome() {
//		getDriver().get("C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://sco.rsinet.com.br/");
		return driver;
	}

}
