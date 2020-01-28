package br.com.edsoft.telas;

import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.BasePage;

public class MarcaPontoPage {

	private WebDriver driver;
	private BasePage basePage;
	
	public MarcaPontoPage(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage(driver);
	}	

	public MarcaPontoPage efetuarMarcacao(){
	  basePage.clicarId("ctl00_ContentConteudo_btnSalvar");
	   return new MarcaPontoPage(driver);
	}
	
}
