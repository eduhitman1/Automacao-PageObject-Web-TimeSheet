package br.com.edsoft.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastrarTimePage {

	private WebDriver driver;

	public CadastrarTimePage(WebDriver driver) {
		this.driver = driver;
	}

	public CadastrarTimePage preencherNomeProjeto(String arg1) {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlProjeto")).click();
		WebElement element3 = driver.findElement(By.name("ctl00$ContentConteudo$ddlProjeto"));
		Select combo3 = new Select(element3);
		combo3.selectByVisibleText(arg1);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherNomeDemanda(String arg1) {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlDemanda")).click();
		WebElement element3 = driver.findElement(By.name("ctl00$ContentConteudo$ddlDemanda"));
		Select combo3 = new Select(element3);
		combo3.selectByVisibleText(arg1);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherNomeTarefa(String arg1) {
		driver.findElement(By.name("ctl00$ContentConteudo$ddlTarefa")).click();
		WebElement element5 = driver.findElement(By.name("ctl00$ContentConteudo$ddlTarefa"));
		Select combo5 = new Select(element5);
		combo5.selectByVisibleText(arg1);
		return new CadastrarTimePage(driver);
	}
	
	
	public void preencherDataAtribuida() {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorformatado = hoje.format(formatador);
		driver.findElement(By.id("ctl00_ContentConteudo_txtData_Trabalhada")).sendKeys(valorformatado);
	}
	
	
	public CadastrarTimePage horasArbitradas(String arg1) {
		driver.findElement(By.name("ctl00$ContentConteudo$txtHoras")).sendKeys(arg1);
		return new CadastrarTimePage(driver);
	}
	
	public CadastrarTimePage descricaoAtividade(String arg1) {
		driver.findElement(By.name("ctl00$ContentConteudo$txtObservacao")).sendKeys(arg1);
		return new CadastrarTimePage(driver);
	}
	
	
	
	
	
	
	
}
