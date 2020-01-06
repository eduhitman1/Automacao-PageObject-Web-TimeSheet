package br.com.edsoft.ct;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.aplicacao.AplicacaoTimeSheet;
import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.core.DSL;
import br.com.edsoft.telas.CadastrarTimePage;
import br.com.edsoft.telas.LoginPage;
import br.com.edsoft.telas.MenuPage;

/*
CTLANCA001 lançamento de timeSheet massa json
*/
public class CTLANCA001 {
	private WebDriver aplicacao;
	private DSL dsl;
	CarregaMassa dadosCarregados = new CarregaMassa();

	@Before
	public void setUp() {
	}

	public CTLANCA001() {
		dadosCarregados.massaJson();
	}

	@Test
	public void CTLANCA001() {
		aplicacao = AplicacaoTimeSheet.createChrome();
		dsl = new DSL(aplicacao);

		
		LoginPage usuario = new LoginPage(aplicacao);
		usuario.fazerLogin();

		MenuPage menu = new MenuPage(aplicacao);
		menu.preencherFilialePlanta().lancaTime();

		CadastrarTimePage cadastraTime = new CadastrarTimePage(aplicacao);
//		cadastraTime.preencherNomeProjeto(dadosCarregados.getNomeProjeto())
//				.preencherNomeDemanda(dadosCarregados.getNomeDemanda()).preencherDataAtribuida()
//				.preencherNomeTarefa(dadosCarregados.getTarefa()).horasArbitradas(dadosCarregados.getHorasArbitradas())
//				.descricaoAtividade(dadosCarregados.getDescricaoAtividade());
//
		cadastraTime.preencherLancaHoras();
		descricaoJavaScript();
	}

	public void descricaoJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) aplicacao;
		js.executeScript("document.getElementById('ctl00_ContentConteudo_txtObservacao').value = 'Estudando Page'");
		js.executeScript("alert('testando descrição de atividade javaScript')");
	}

//	@After
//	public void finalizado() {
//		driver.close();
//	}

}
