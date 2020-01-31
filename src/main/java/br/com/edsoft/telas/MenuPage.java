package br.com.edsoft.telas;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.apoio.Date;
import br.com.edsoft.core.BasePage;

public class MenuPage {

	private WebDriver driver;
	private BasePage basePage;
	CarregaMassa dadosCarregados = new CarregaMassa();

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage(driver);
//		dadosCarregados.massaJson();
		dadosCarregados.massaBanco();
	}

	public MenuPage preencherFilialePlanta() {
		validaBemVindo().
		filialDaSessao(dadosCarregados.getFilial());
		informoPlanta(dadosCarregados.getPlanta());
		return new MenuPage(driver);
	}

	public MenuPage validaBemVindo() {
		String texto = basePage.obterTextoXpath("h2", "class", "col-md-6");
		Assert.assertEquals("Bem vindo, ao SCO - Sistema de Controle de Operações!", texto);
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"valida texto: "+texto);
		return new MenuPage(driver);
	}

	public MenuPage filialDaSessao(String filial) {
		basePage.clicarName("ctl00$ContentConteudo$ddlFilial");
		basePage.selecionarCombo("ctl00$ContentConteudo$ddlFilial", filial);
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"filial selecionada: "+filial);
		return new MenuPage(driver);
	}

	public MenuPage informoPlanta(String planta) {
		basePage.clicarName("ctl00$ContentConteudo$ddlPlantasUsuario");
		basePage.selecionarCombo("ctl00$ContentConteudo$ddlPlantasUsuario", planta);
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"planta selecionada: "+planta);
		return new MenuPage(driver);
	}

	public MenuPage lancaTime() {
		basePage.clicarXpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a");
		basePage.linkTexto("Lançamento de TimeSheet");
		basePage.clicarId("ctl00_ContentConteudo_btnAddAcao");
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"tela preenchimento lança time Sheet");
		return new MenuPage(driver);
	}

	public MenuPage PontoTime() {
		basePage.clickXpath("a", "class", "dropdown-toggle");
		basePage.linkTexto("Lançamento de Ponto");
		return new MenuPage(driver);
	}

}
