package br.com.edsoft.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DSL {

	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void capturaChave() {
		String chave = driver.findElement(By.xpath("//*[@id=\"caption\"]")).getText();
		 inserirChave(chave);
	}
	
	public void inserirChave(String chave) {
		WebElement chaveAcess = driver.findElement(By.id("txtcaption"));
		chaveAcess.sendKeys(chave);
	}

	public void escreveId(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public void escreveName(String id_campo, String texto) {
		driver.findElement(By.name(id_campo)).sendKeys(texto);
	}
	
	public void clickBotao(String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	public WebElement recuperaElemento(String tipoAtributo, String atributo, String valor) {
		return driver.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo + "='" + valor + "']"));
	}

	public void escreveXpath(String tipoAtributo, String atributo, String valor, String texto) {
		this.recuperaElemento(tipoAtributo, atributo, valor).sendKeys(texto);
	}
	
	public void capturarTextXpath(String tipoAtributo, String atributo, String valor) {
		// *[@id="txtLogin"]
		driver.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo + "='" + valor + "']")).getText();
	}
	

}
