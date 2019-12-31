

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.aplicacao.Web;
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
		LoginPage usuario = new LoginPage(driver);
		usuario.palavraChave().login(dadosCarregados.getLogin(), dadosCarregados.getSenha()).entrar();

		MenuPage menu = new MenuPage(driver);
		menu.filialDaSessao(dadosCarregados.getFilial()).informoPlanta(dadosCarregados.getPlanta()).PontoTime();

		MarcaPontoPage marcaPonto = new MarcaPontoPage(driver);
		marcaPonto.efetuarMarcacao();

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
