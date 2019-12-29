package br.com.edsoft.ct;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.apoio.Web;
import br.com.edsoft.core.DSL;
import br.com.edsoft.telas.CadastrarTimePage;
import br.com.edsoft.telas.LoginPage;
import br.com.edsoft.telas.MenuPage;
/*
CTLANCA001 lançamento de timeSheet
*/

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LancaTimeExcel.csv")
public class CTLANCA001 {
	private WebDriver driver;
	private DSL dsl;
	CarregaMassa dadosCarregados = new CarregaMassa();

	@Before
	public void setUp() {
		driver = Web.createChrome();
		dsl = new DSL(driver);
	}

	public CTLANCA001() {
     dadosCarregados.massaJson();
//     dadosCarregados.LancaTimeExcel(dadosCarregados.getLogin(),dadosCarregados.getSenha(), dadosCarregados.getFilial(), dadosCarregados.getPlanta(), dadosCarregados.getNomeProjeto(), dadosCarregados.getNomeDemanda(), dadosCarregados.getTarefa(), dadosCarregados.getHorasArbitradas(), dadosCarregados.getDescricaoAtividade());

	}

	@Test
	public void lancaHoras() {
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

	@Test
	@Ignore
	public LoginPage LancaTimeExcel(@Param(name = "login") String login, @Param(name = "senha") String senha,
			@Param(name = "filial") String filial, @Param(name = "planta") String planta,
			@Param(name = "nomeProjeto") String nomeProjeto, @Param(name = "nomeDemanda") String nomeDemanda,
			@Param(name = "tarefa") String tarefa, @Param(name = "horasArbitradas") String horasArbitradas,
			@Param(name = "descricacaoAtividade") String descricacaoAtividade) {

		dadosCarregados.setLogin(login);

		LoginPage usuario = new LoginPage(driver);
		usuario.palavraChave().login(dadosCarregados.getLogin(), senha).entrar();

		MenuPage menu = new MenuPage(driver);
		menu.filialDaSessao(filial).informoPlanta(planta).lancaTime();

		CadastrarTimePage cadastrarPage = new CadastrarTimePage(driver);
		cadastrarPage.preencherNomeProjeto(nomeProjeto).preencherNomeDemanda(nomeDemanda).preencherNomeTarefa(tarefa)
				.preencherDataAtribuida().horasArbitradas(horasArbitradas).descricaoAtividade(descricacaoAtividade);

		return new LoginPage(driver);

	}

//	@After
//	public void finalizado() {
//		driver.close();
//	}

}
