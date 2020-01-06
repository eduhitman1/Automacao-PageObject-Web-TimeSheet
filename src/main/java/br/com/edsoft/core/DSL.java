package br.com.edsoft.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

	public void escreveName(String name_campo, String texto) {
		driver.findElement(By.name(name_campo)).sendKeys(texto);
	}

	public void clickId(String Id_campo) {
		driver.findElement(By.id(Id_campo)).click();
	}

	public void clickName(String name_campo) {
		driver.findElement(By.name(name_campo)).click();
	}

	public void selecionarCombo(String name, String filial) {
		WebElement element = driver.findElement(By.name(name));
		Select combo = new Select(element);
		combo.selectByVisibleText(filial);
	}

	public void clickXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void linkTexto(String linktexto) {
		driver.findElement(By.linkText(linktexto)).click();
	}

	public WebElement recuperaElemento(String tipoAtributo, String atributo, String valor) {
		return driver.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo + "='" + valor + "']"));
	}

	public void escreveXpath(String tipoAtributo, String atributo, String valor, String texto) {
		this.recuperaElemento(tipoAtributo, atributo, valor).sendKeys(texto);
	}

	public WebElement clickElemento(String tipoAtributo, String atributo, String valor) {
		return driver.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo + "='" + valor + "']"));
	}

	public void clickXpath(String tipoAtributo, String atributo, String valor) {
		this.clickElemento(tipoAtributo, atributo, valor).click();
	}

	public String capturarTextXpath(String tipoAtributo, String atributo, String valor) {
		// *[@id="txtLogin"]
		String texto =   driver.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo + "='" + valor + "']")).getText();
		
		
		return texto;
	}

}
