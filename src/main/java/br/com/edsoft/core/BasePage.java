package br.com.edsoft.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.edsoft.apoio.Date;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void capturaChave() {
//		Date datetime = new Date();
//		datetime.DateTime();
		String chave = driver.findElement(By.xpath("//*[@id=\"caption\"]")).getText();
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada() + " " + datetime.getHoraFormatada() + " |" + "chave capturada:" + chave);
		inserirChave(chave);
	}

	public void inserirChave(String chave) {
		WebElement chaveAcess = driver.findElement(By.id("txtcaption"));
		chaveAcess.sendKeys(chave);
	}

	public void digitaTextoId(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}

	public void digitaTextoName(String name_campo, String texto) {
		driver.findElement(By.name(name_campo)).sendKeys(texto);
	}

	public void clicarId(String Id_campo) {
		driver.findElement(By.id(Id_campo)).click();
	}

	public void clicarName(String name_campo) {
		driver.findElement(By.name(name_campo)).click();
	}

	public void selecionarCombo(String name, String filial) {
		WebElement element = driver.findElement(By.name(name));
		Select combo = new Select(element);
		combo.selectByVisibleText(filial);
	}

	public void clicarXpath(String xpath) {
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

	public String obterTextoXpath(String tipoAtributo, String atributo, String valor) {
		// *[@id="txtLogin"]
		String texto = driver.findElement(By.xpath("//" + tipoAtributo + "[@" + atributo + "='" + valor + "']"))
				.getText();

		return texto;
	}

}
