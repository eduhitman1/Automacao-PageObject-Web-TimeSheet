package br.com.edsoft.telas;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LoginExcelData.csv")
public class LoginPage {
	private final WebDriver driver;
	private DSL dsl;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		dsl = new DSL(driver);
	}

	public LoginPage palavraChave() {
		dsl.capturaChave();
		return new LoginPage(driver);
	}

	public LoginPage login(String login, String senha) {
		dsl.escreveId("txtLogin", login);
		dsl.escreveId("txtSenha", senha);
		return new LoginPage(driver);
	}

	public LoginPage entrar() {
		dsl.clickId("btnEntrar");
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
