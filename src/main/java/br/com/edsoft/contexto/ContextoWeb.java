package br.com.edsoft.contexto;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class ContextoWeb {
	
	WebDriver driverChrome = new ChromeDriver();
	WebDriver driverFireFox = new FirefoxDriver();
	
	public enum Navegador{
		InternetExplorer,
		GoogleChrome,
		Firefox
	}
		
//	public void TipoNavegador() {
//	switch(navegadores.) {
//	
//	case 
//	System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
//	
//	System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
//	
//	System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
//	}
	
	
	private static Hashtable<String, String> navegadores = new Hashtable<String , String>();
	static {
		navegadores.put(BrowserType.GOOGLECHROME,"chrome.exe");
	}


}
		
		
