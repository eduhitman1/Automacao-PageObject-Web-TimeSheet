package br.com.edsoft.teste;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;
import br.com.edsoft.pages.CadastrarTimePage;
import br.com.edsoft.pages.LoginPage;
import br.com.edsoft.pages.MenuPage;
import br.com.edsoft.suport.Web;


//@RunWith(DataDrivenTestRunner.class)
//@DataLoader(filePaths = "massaLoginExcelData.csv")
public class LancaTimeTest {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void setUp() {
		driver = Web.createChrome();
		dsl = new DSL(driver);
	}

	@Test
	public void deverEntraComUmUsuario() {
		LoginPage usuario = new LoginPage(driver);
//		dsl.escreveXpath("*", "id", "txtLogin", "Testo automation");
//		usuario.palavraChave().loginMassaJson().entrar();
		usuario.palavraChave().loginMassaExcel("", "").entrar();
		
		

		MenuPage menu = new MenuPage(driver);
		
		
		menu.filialDaSessao("OSASCO - OPERAÇÕES");
		menu.informoPlanta("ITAU - FÁBRICA DE TESTES");
		menu.lancaTime();

		CadastrarTimePage cadastroTime = new CadastrarTimePage(driver);
		cadastroTime.preencherNomeProjeto("(7505) - TREINAMENTO HUBB - MODELO E TRABALHO ITAU");
		cadastroTime.preencherNomeDemanda("Treinamento Dezembro");
		cadastroTime.preencherNomeTarefa("Treinamento Automação Trainee");
		cadastroTime.preencherDataAtribuida();
		cadastroTime.horasArbitradas("0080");
	}
	
	
	
	
	

//	@After
//	public void finalizado() {
//		driver.close();
//	}

}
