package br.com.edsoft.telas;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.apoio.Date;
import br.com.edsoft.core.BasePage;
import br.com.edsoft.core.Generator;
import br.com.edsoft.core.Screenshot;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LoginExcelData.csv")
public class LoginPage {
	private final WebDriver driver;
	private BasePage basePage;
	CarregaMassa dadosCarregados = new CarregaMassa();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage(driver);
//		dadosCarregados.massaJson();
		dadosCarregados.massaBanco();
	}
	@Rule
	public TestName test = new TestName();
	
	public void fazerLogin() {
		palavraChave();
		login(dadosCarregados.getLogin(), dadosCarregados.getSenha());
		entrar();
	}
	
	public LoginPage palavraChave() {
		basePage.capturaChave();
		return new LoginPage(driver);
	}

	public LoginPage login(String login, String senha) {
		basePage.digitaTextoName("txtLogin", login);
		basePage.digitaTextoId("txtSenha", senha);
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"login: "+login);
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"senha: "+senha);
		return new LoginPage(driver);
	}
	
	public LoginPage entrar() {
		basePage.clicarId("btnEntrar");
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"acesso ao menu");
		return new LoginPage(driver);
	}

//	public LoginPage loginMassaExcel() {
//		FileInputStream fispPlanilha = null;
//////		String login = "";
//		String senha = "";
//
//		try {
//			File file = new File("C:/Users/eduardo.matias/Documents/eclipce-workspace/Automacao-PageObject-RSI-timeSheet/target/ExcelArv/massaLoginExcelData.xlsx");
//			fispPlanilha = new FileInputStream(file);
//			XSSFWorkbook workbook = new XSSFWorkbook(fispPlanilha);
//			XSSFSheet sheet = workbook.getSheetAt(0);
//			for (Row row : sheet) {
//				if (row.getRowNum() != 0) {
//					break;
//				}
//				for (Cell cell : row) {
//					String conteudoCelula = "";
//					switch (cell.getCellType()) {
//
//					case Cell.CELL_TYPE_STRING:
//						conteudoCelula = cell.getStringCellValue();
//						System.out.println("conteudo = " + conteudoCelula);
//						break;
//
//					case Cell.CELL_TYPE_NUMERIC:
//						System.out.println("" + cell.getStringCellValue());
//						break;
//
//					case Cell.CELL_TYPE_FORMULA:
//						System.out.println("" + cell.getStringCellValue());
//						break;
//					}
//					if (cell.getColumnIndex() == 0) {
//						dadosCarregados.setLogin((String) cell.getStringCellValue());
//					} else if (cell.getColumnIndex() == 1) {
//						senha = conteudoCelula;
//					}
//				}
//			}
//			System.out.println("login = " + dadosCarregados.getLogin() + "\nsenha = " + senha);
//		} catch (FileNotFoundException ex) {
//			System.out.println("Erro" + ex.getMessage());
//		} catch (IOException ex) {
//			System.out.println("Erro" + ex.getMessage());
//		}
//		LoginPage usuario = new LoginPage(driver);
//		usuario.login(dadosCarregados.getLogin(), senha).entrar();
//
//		MenuPage menu = new MenuPage(driver);
//		menu.filialDaSessao(dadosCarregados.getFilial());
//		return new LoginPage(driver);
//	}

}
