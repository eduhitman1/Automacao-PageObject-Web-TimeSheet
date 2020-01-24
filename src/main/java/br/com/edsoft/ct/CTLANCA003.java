package br.com.edsoft.ct;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.aplicacao.AplicacaoTimeSheet;
import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.core.BasePage;
import br.com.edsoft.telas.CadastrarTimePage;
import br.com.edsoft.telas.LoginPage;
import br.com.edsoft.telas.MenuPage;

/*
CTLANCA002 lançamento de timeSheet massa excel 
*/

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LancaTimeExcel.csv")
public class CTLANCA003 {

	private WebDriver driver;
	private BasePage basePage;

	@Before
	public void setUp() {
		driver = AplicacaoTimeSheet.createChrome();
		basePage = new BasePage(driver);
	}

	public CTLANCA003() {
	}

	@Test
	public LoginPage LancaTimeExcel(@Param(name = "login") String login, 
			@Param(name = "senha") String senha,
			@Param(name = "filial") String filial,
			@Param(name = "planta") String planta,
			@Param(name = "nomeProjeto") String nomeProjeto, 
			@Param(name = "nomeDemanda") String nomeDemanda,
			@Param(name = "tarefa") String tarefa, 
			@Param(name = "horasArbitradas") String horasArbitradas,
			@Param(name = "descricacaoAtividade") String descricacaoAtividade) {

//		dadosCarregados.setLogin(login);

		LoginPage usuario = new LoginPage(driver);
		usuario.palavraChave().login(login, senha).entrar();

		MenuPage menu = new MenuPage(driver);
		menu.filialDaSessao(filial).informoPlanta(planta).lancaTime();

		CadastrarTimePage cadastrarPage = new CadastrarTimePage(driver);
		cadastrarPage.preencherNomeProjeto(nomeProjeto).preencherNomeDemanda(nomeDemanda).preencherNomeTarefa(tarefa)
				.preencherDataAtribuida().horasArbitradas(horasArbitradas).descricaoAtividade(descricacaoAtividade);

		return new LoginPage(driver);
	}

}
