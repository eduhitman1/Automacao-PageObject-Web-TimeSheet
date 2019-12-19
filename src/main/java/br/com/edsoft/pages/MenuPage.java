package br.com.edsoft.pages;

import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;

public class MenuPage {

	private WebDriver driver;
	private DSL dsl;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		dsl = new DSL(driver);
	}

	public MenuPage filialDaSessao() {
		dsl.clickName("ctl00$ContentConteudo$ddlFilial");
		dsl.selecionarCombo("ctl00$ContentConteudo$ddlFilial", "OSASCO - OPERAÇÕES");
		return new MenuPage(driver);
	}

	public MenuPage informoPlanta() {
		dsl.clickName("ctl00$ContentConteudo$ddlPlantasUsuario");
		dsl.selecionarCombo("ctl00$ContentConteudo$ddlPlantasUsuario", "ITAU - FÁBRICA DE TESTES");
		return new MenuPage(driver);
	}

	public MenuPage lancaTime() {
		dsl.clickXpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a");
		dsl.linkTexto("Lançamento de TimeSheet");
		dsl.clickId("ctl00_ContentConteudo_btnAddAcao");
		return new MenuPage(driver);
	}

}
