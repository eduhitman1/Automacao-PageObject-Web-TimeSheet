package br.com.edsoft.ct;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.aplicacao.AplicacaoTimeSheet;
import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.core.DSL;
import br.com.edsoft.telas.LoginPage;
import br.com.edsoft.telas.MarcaPontoPage;
import br.com.edsoft.telas.MenuPage;

/*
CTLANCA003 marcação de ponto massa json
*/
public class CTPONTO003 {
	private WebDriver driver;
	private DSL dsl;
	CarregaMassa dadosCarregados = new CarregaMassa();

	public CTPONTO003() {
		dadosCarregados.massaJson();
	}

	@Test
	public void CTPONTO003() {
		driver = AplicacaoTimeSheet.createChrome();
		dsl = new DSL(driver);
		
		LoginPage usuario = new LoginPage(driver);
		usuario.fazerLogin();

		MenuPage menu = new MenuPage(driver);
		menu.preencherFilialePlanta().PontoTime();

		MarcaPontoPage marcaPonto = new MarcaPontoPage(driver);
		marcaPonto.efetuarMarcacao();

	}

	@After
	public void finalizado() {
		driver.close();
	}

}
