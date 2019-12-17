package br.com.edsoft.teste;

import org.openqa.selenium.WebElement;

public class ElementoWeb {

	private WebElement we;
	
	ElementoWeb(WebElement we){
		this.we = we;
	}
	
	public void escrever(String texto) {
		we.sendKeys(texto);
	}
	
	
	
	
	
}
