package br.com.edsoft.teste;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;
import br.com.edsoft.pages.CadastrarTimePage;
import br.com.edsoft.pages.LoginPage;
import br.com.edsoft.pages.MenuPage;
import br.com.edsoft.suport.Web;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LancaTimeExcel.csv")
public class LancaTimeTest {
	private WebDriver driver;
	private DSL dsl;
   
	@Test
	public void LancaTimeJson() {
		LoginPage usuario = new LoginPage(driver);
		usuario.palavraChave().loginMassaJson();
//		usuario.palavraChave().loginMassaExcel();
	}
	
	@Test
	public LoginPage LancaTimeExcel(
			@Param(name="login")String login, 
			@Param(name="senha")String senha,
		    @Param(name="filial")String filial,
		    @Param(name="planta")String planta,
		    @Param(name="nomeProjeto")String nomeProjeto,
		    @Param(name="nomeDemanda")String nomeDemanda,
		    @Param(name="tarefa")String tarefa,
		    @Param(name="horasArbitradas")String horasArbitradas,
		    @Param(name="descricacaoAtividade")String descricacaoAtividade 
			) {
		LoginPage usuario = new LoginPage(driver);
		usuario.palavraChave().
		login(login, senha)
		.entrar();
		
		MenuPage menu = new MenuPage(driver);
		menu.filialDaSessao(filial)
		.informoPlanta(planta)
		.lancaTime();
		
		CadastrarTimePage cadastrarPage = new CadastrarTimePage(driver);
		cadastrarPage.preencherNomeProjeto(nomeProjeto)
		.preencherNomeDemanda(nomeDemanda)
		.preencherNomeTarefa(tarefa)
		.preencherDataAtribuida()
		.horasArbitradas(horasArbitradas)
		.descricaoAtividade(descricacaoAtividade);
		return new LoginPage(driver);
	}

	@Test
	@Ignore
	public void MarcacaoDePonto() {
		
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
