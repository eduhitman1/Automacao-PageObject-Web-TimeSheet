package br.com.edsoft.teste;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;
import br.com.edsoft.pages.LoginPage;
import br.com.edsoft.suport.Web;

public class LancaTimeTest {
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void setUp() {
		driver = Web.createChrome();
		dsl = new DSL(driver);
	}
	
//	@After
//	public void finalizado() {
//		driver.close();
//	}
	
    @Test
	public void LancamentoDeTimeSheet() {
		LoginPage usuario = new LoginPage(driver);
		usuario.palavraChave().loginMassaJson();
//		usuario.palavraChave().loginMassaExcel();
	}
    
    @Test
    @Ignore
    public void MarcacaoDePonto() {
        
       
    
    }    
    
}
