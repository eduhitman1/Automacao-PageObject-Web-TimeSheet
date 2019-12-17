package br.com.edsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.edsoft.core.DSL;

public class MenuPage {

	private WebDriver driver;
	private DSL dsl;
	

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		dsl = new DSL(driver);
	}

	public MenuPage filialDaSessao(String filial) {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlFilial")).click();
//		dsl.clickBotao("ctl00$ContentConteudo$ddlFilial");
		
		
//		dsl.recuperaElemento("*", "id", "ctl00_ContentConteudo_ddlFilial").sendKeys(keysToSend);
		WebElement element = driver.findElement(By.name("ctl00$ContentConteudo$ddlFilial"));
		Select combo = new Select(element);
		combo.selectByVisibleText(filial);
		
		
		return new MenuPage(driver);
	}

	public MenuPage informoPlanta(String planta) {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlPlantasUsuario")).click();
		WebElement element2 = driver.findElement(By.name("ctl00$ContentConteudo$ddlPlantasUsuario"));
		Select combo2 = new Select(element2);
		combo2.selectByVisibleText(planta);
		return new MenuPage(driver);
	}

	public void lancaTime() {
		driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
		driver.findElement(By.linkText("Lançamento de TimeSheet")).click();
		driver.findElement(By.id("ctl00_ContentConteudo_btnAddAcao")).click();
	}

}
