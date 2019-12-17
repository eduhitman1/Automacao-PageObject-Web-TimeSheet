package br.com.edsoft.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameExemplo {

	private static WebDriver driver;
	
	public FrameExemplo() {
		
	}
	
	public static ElementoWeb recuperaElemento(String tipoAtributo, String atributo, String valor) {
		return new ElementoWeb(driver.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo +  "='" + valor + "']")));
	}
	
	
}
