package br.com.edsoft.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;


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

	public LoginPage loginMassaJson() {
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		String login;
		String senha;
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader("target/JsonArv/massaLogin.json"));
			login = (String) jsonObject.get("login");
			senha = (String) jsonObject.get("senha");
			System.out.printf("login: %s\nSenha: %s\n", login, senha);
			login(login, senha);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new LoginPage(driver);
	}

	public void login(String email, String senha) {
		dsl.escreveId("txtLogin", email);
		dsl.escreveId("txtSenha", senha);
	}

	public LoginPage loginMassaExcel(String email, String senha) {
		FileInputStream fispPlanilha = null;
		try {
			File file = new File("C:\\Users\\eduardo.matias\\Documents\\eclipce-workspace\\Automacao-PageObject-RSI-timeSheet\\target\\ExcelArv\\massaLoginExcelData.xlsx");
			fispPlanilha = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fispPlanilha);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				if (row.getRowNum() != 0) {
					break;
				}
				for (Cell cell : row) {
					String conteudoCelula = "";
					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_STRING:
						conteudoCelula = cell.getStringCellValue();
						System.out.println("conteudo = " + conteudoCelula);
						break;

					case Cell.CELL_TYPE_NUMERIC:
						System.out.println("" + cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_FORMULA:
						System.out.println("" + cell.getStringCellValue());
						break;
					}
					if (cell.getColumnIndex() == 0) {
						email = conteudoCelula;
					} else if (cell.getColumnIndex() == 1) {
						senha = conteudoCelula;
					}
				}
			}
			System.out.println("email = " + email + "\nsenha = " + senha);
		} catch (FileNotFoundException ex) {
			System.out.println("Erro" + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Erro" + ex.getMessage());
		}
		dsl.escreveId("txtLogin", email);
		dsl.escreveId("txtSenha", senha);
		return new LoginPage(driver);
	}
	public LoginPage entrar() {
		dsl.clickBotao("btnEntrar");
		return new LoginPage(driver);
	}
}
