package br.com.edsoft.ct;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.aplicacao.AplicacaoTimeSheet;
import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.core.BasePage;
import br.com.edsoft.core.BaseTest;
import br.com.edsoft.telas.LoginPage;
import br.com.edsoft.telas.MarcaPontoPage;
import br.com.edsoft.telas.MenuPage;

/*
CTLANCA003 marcação de ponto massa json
*/
public class CTLANCA001 extends BaseTest {
	private WebDriver driver;
	private BasePage basePage;
	CarregaMassa dadosCarregados = new CarregaMassa();

	public CTLANCA001() {
		dadosCarregados.massaJson();
	}

	@Test
	public void CTPONTO001() {
		driver = AplicacaoTimeSheet.createChrome();
		basePage = new BasePage(driver);
		try {
		LoginPage usuario = new LoginPage(driver);
		usuario.fazerLogin();
		
		MenuPage menu = new MenuPage(driver);
		menu.preencherFilialePlanta().PontoTime();

		MarcaPontoPage marcaPonto = new MarcaPontoPage(driver);
//		marcaPonto.efetuarMarcacao();
		
		}catch(Exception ex) {
			ex.getStackTrace();
		}
	}

	@After
	public void finalizado() {
		driver.close();
	}

}
