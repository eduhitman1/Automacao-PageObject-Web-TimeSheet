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
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;
import br.com.edsoft.suport.CarregaDados;



@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LoginExcelData.csv")
public class LoginPage {
	private final WebDriver driver;
	private DSL dsl;
	CarregaDados dadosCarregados = new CarregaDados();

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
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader("src/main/resources/LoginData.json"));
			dadosCarregados.setLogin((String) jsonObject.get("login"));
			dadosCarregados.setSenha((String) jsonObject.get("senha"));
			dadosCarregados.setFilial((String) jsonObject.get("filial"));
			dadosCarregados.setPlanta((String) jsonObject.get("planta"));
			dadosCarregados.setNomeProjeto((String) jsonObject.get("nomeProjeto"));
			dadosCarregados.setNomeDemanda((String) jsonObject.get("nomeDemanda"));
			dadosCarregados.setTarefa((String) jsonObject.get("tarefa"));
			dadosCarregados.setHorasArbitradas((String) jsonObject.get("horasArbitradas"));
			dadosCarregados.setDescricaoAtividade((String) jsonObject.get("descricacaoAtividade"));

			System.out.printf("Login: %s\nSenha: %s\nFilial: %s\nPlanta: %s\nNome do Projeto: %s\nNome do Demanda: %s\nNome da Tarefa: %s\nHoras Arbitradas: %s\nDescrição de Atividade: %s \n",
			dadosCarregados.getLogin(), dadosCarregados.getSenha(), dadosCarregados.getFilial(), dadosCarregados.getPlanta(), dadosCarregados.getNomeProjeto(), dadosCarregados.getNomeDemanda(), dadosCarregados.getTarefa(),
			dadosCarregados.getHorasArbitradas(), dadosCarregados.getDescricaoAtividade());

			LoginPage usuario = new LoginPage(driver);
			MenuPage menu = new MenuPage(driver);
			CadastrarTimePage cadastraTime = new CadastrarTimePage(driver);

			usuario.login(dadosCarregados.getLogin(),dadosCarregados.getSenha()).entrar();
			menu.filialDaSessao(dadosCarregados.getFilial()).informoPlanta(dadosCarregados.getPlanta()).lancaTime();
			cadastraTime.preencherNomeProjeto(dadosCarregados.getNomeProjeto()).preencherNomeDemanda(dadosCarregados.getNomeDemanda()).preencherDataAtribuida()
					.preencherNomeTarefa(dadosCarregados.getTarefa()).horasArbitradas(dadosCarregados.getHorasArbitradas())
					.descricaoAtividade(dadosCarregados.getDescricaoAtividade());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
	
	
	
	
	
	
	
	
	public LoginPage loginMassaExcel() {
		FileInputStream fispPlanilha = null;
////		String login = "";
		String senha = "";

		try {
			File file = new File("C:/Users/eduardo.matias/Documents/eclipce-workspace/Automacao-PageObject-RSI-timeSheet/target/ExcelArv/massaLoginExcelData.xlsx");
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
						dadosCarregados.setLogin((String) cell.getStringCellValue());
					} else if (cell.getColumnIndex() == 1) {
						senha = conteudoCelula;
					}
				}
			}
			System.out.println("login = " + dadosCarregados.getLogin() + "\nsenha = " + senha);
		} catch (FileNotFoundException ex) {
			System.out.println("Erro" + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Erro" + ex.getMessage());
		}
		LoginPage usuario = new LoginPage(driver);
		usuario.login(dadosCarregados.getLogin(), senha).entrar();

		MenuPage menu = new MenuPage(driver);
		menu.filialDaSessao(dadosCarregados.getFilial());
		return new LoginPage(driver);
	}


	
	
	
	
	
}
