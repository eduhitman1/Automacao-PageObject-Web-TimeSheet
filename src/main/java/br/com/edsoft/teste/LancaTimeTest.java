package br.com.edsoft.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;
import br.com.edsoft.pages.CadastrarTimePage;
import br.com.edsoft.pages.LoginPage;
import br.com.edsoft.pages.MenuPage;
import br.com.edsoft.suport.Web;

public class LancaTimeTest {
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void setUp() {
		driver = Web.createChrome();
		dsl = new DSL(driver);
	}
	
	@After
	public void finalizado() {
		driver.close();
	}
	
	@Test
	public void LancamentoDeTimeSheet() {
		LoginPage usuario = new LoginPage(driver);
		MenuPage menu = new MenuPage(driver);
		CadastrarTimePage cadastroTime = new CadastrarTimePage(driver);
//		usuario.palavraChave().loginMassaExcel().entrar();
		usuario.palavraChave().loginMassaJson().entrar();
		menu.filialDaSessao().informoPlanta().lancaTime();
		cadastroTime.preencherNomeProjeto().preencherNomeDemanda().preencherNomeTarefa().preencherDataAtribuida().horasArbitradas().descricaoAtividade();
	}
}
