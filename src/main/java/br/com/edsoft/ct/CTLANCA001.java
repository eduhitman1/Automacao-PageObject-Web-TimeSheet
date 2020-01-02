package br.com.edsoft.ct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.aplicacao.Web;
import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.core.DSL;
import br.com.edsoft.telas.CadastrarTimePage;
import br.com.edsoft.telas.LoginPage;
import br.com.edsoft.telas.MenuPage;
/*
CTLANCA001 lançamento de timeSheet massa json
*/
public class CTLANCA001 {
	private WebDriver driver;
	private DSL dsl;
	CarregaMassa dadosCarregados = new CarregaMassa();

	public CTLANCA001() {
     dadosCarregados.massaJson();
	}

	@Test
	public void CTLANCA001 () {
		LoginPage usuario = new LoginPage(driver);
		usuario.palavraChave().login(dadosCarregados.getLogin(), dadosCarregados.getSenha()).entrar();

		MenuPage menu = new MenuPage(driver);
		menu.filialDaSessao(dadosCarregados.getFilial()).informoPlanta(dadosCarregados.getPlanta()).lancaTime();

		CadastrarTimePage cadastraTime = new CadastrarTimePage(driver);
		cadastraTime.preencherNomeProjeto(dadosCarregados.getNomeProjeto())
				.preencherNomeDemanda(dadosCarregados.getNomeDemanda()).preencherDataAtribuida()
				.preencherNomeTarefa(dadosCarregados.getTarefa()).horasArbitradas(dadosCarregados.getHorasArbitradas())
				.descricaoAtividade(dadosCarregados.getDescricaoAtividade());
	}


	@Before
	public void setUp() {
		driver = Web.createChrome();
		dsl = new DSL(driver);
	}
	
//	@After
//	public void finalizado() {
//		driver.close();
//	}

}
