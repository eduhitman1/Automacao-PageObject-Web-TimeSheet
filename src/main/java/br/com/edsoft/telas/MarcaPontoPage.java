package br.com.edsoft.telas;

import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;

public class MarcaPontoPage {

	private WebDriver driver;
	private DSL dsl;
	
	public MarcaPontoPage(WebDriver driver) {
		this.driver = driver;
		dsl = new DSL(driver);
	}	

	public MarcaPontoPage efetuarMarcacao(){
	  dsl.clickId("ctl00_ContentConteudo_btnSalvar");
	   return new MarcaPontoPage(driver);
	}
	
}
