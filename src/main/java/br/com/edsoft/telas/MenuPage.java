package br.com.edsoft.telas;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.core.DSL;

public class MenuPage {

	private WebDriver driver;
	private DSL dsl;
	CarregaMassa dadosCarregados = new CarregaMassa();

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		dsl = new DSL(driver);
		dadosCarregados.massaJson();
	}

	public MenuPage preencherFilialePlanta() {
		validaBemVindo().
		filialDaSessao(dadosCarregados.getFilial());
		informoPlanta(dadosCarregados.getPlanta());
		return new MenuPage(driver);
	}

	public MenuPage validaBemVindo() {
		String texto = dsl.capturarTextXpath("h2", "class", "col-md-6");
		Assert.assertEquals("Bem vindo, ao SCO - Sistema de Controle de Operações!", texto);
		System.out.println("valida texto: "+texto);
		return new MenuPage(driver);
	}

	public MenuPage filialDaSessao(String filial) {
		dsl.clickName("ctl00$ContentConteudo$ddlFilial");
		dsl.selecionarCombo("ctl00$ContentConteudo$ddlFilial", filial);
		System.out.println("filial selecionada: "+filial);
		return new MenuPage(driver);
	}

	public MenuPage informoPlanta(String planta) {
		dsl.clickName("ctl00$ContentConteudo$ddlPlantasUsuario");
		dsl.selecionarCombo("ctl00$ContentConteudo$ddlPlantasUsuario", planta);
		System.out.println("planta selecionada: "+planta);
		return new MenuPage(driver);
	}

	public MenuPage lancaTime() {
		dsl.clickXpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a");
		dsl.linkTexto("Lançamento de TimeSheet");
		dsl.clickId("ctl00_ContentConteudo_btnAddAcao");
		System.out.println("tela preenchimento lança time Sheet");
		return new MenuPage(driver);
	}

	public MenuPage PontoTime() {
		dsl.clickXpath("a", "class", "dropdown-toggle");
		dsl.linkTexto("Lançamento de Ponto");
		return new MenuPage(driver);
	}

}
