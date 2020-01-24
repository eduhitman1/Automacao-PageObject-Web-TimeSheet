package br.com.edsoft.ct;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.aplicacao.AplicacaoTimeSheet;
import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.core.BasePage;
import br.com.edsoft.core.BaseTest;
import br.com.edsoft.core.ExtentReport;
import br.com.edsoft.core.Generator;
import br.com.edsoft.core.Screenshot;
import br.com.edsoft.telas.CadastrarTimePage;
import br.com.edsoft.telas.LoginPage;
import br.com.edsoft.telas.MenuPage;

/*
CTLANCA001 lançamento de timeSheet massa json
*/
public class CTLANCA002 extends BaseTest{
	private WebDriver aplicacao;
	private BasePage basePage;
	CarregaMassa dadosCarregados = new CarregaMassa();
	

	public CTLANCA002() {
		dadosCarregados.massaJson();
	}

	@Test
	public void CTLANCA002() throws IOException {
		aplicacao = AplicacaoTimeSheet.createChrome();
		basePage = new BasePage(aplicacao);

		LoginPage usuario = new LoginPage(aplicacao);
		usuario.fazerLogin();
		
		
		

		MenuPage menu = new MenuPage(aplicacao);
		menu.preencherFilialePlanta().lancaTime();

//		CadastrarTimePage cadastraTime = new CadastrarTimePage(aplicacao);
//		cadastraTime.preencherLancaHoras();
//		descricaoJavaScript();

		ExtentReport report = new ExtentReport();
		report.extendReport();
	}

//	public void descricaoJavaScript() {
//		JavascriptExecutor js = (JavascriptExecutor) aplicacao;
//		js.executeScript("document.getElementById('ctl00_ContentConteudo_txtObservacao').value = 'Estudando Page'");
//		js.executeScript("alert('testando descrição de atividade javaScript')");
//	}
//
//	@After
//	public void finalizado() {
//		aplicacao.close();
//	}

}
