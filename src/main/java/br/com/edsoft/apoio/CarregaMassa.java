package br.com.edsoft.apoio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "LancaTimeExcel.csv")
public class CarregaMassa {
	private String login;
	private String senha;
	private String filial;
	private String planta;
	private String nomeProjeto;
	private String nomeDemanda;
	private String tarefa;
	private String horasArbitradas;
	private String descricaoAtividade;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getNomeDemanda() {
		return nomeDemanda;
	}

	public void setNomeDemanda(String nomeDemanda) {
		this.nomeDemanda = nomeDemanda;
	}

	public String getTarefa() {
		return tarefa;
	}

	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}

	public String getHorasArbitradas() {
		return horasArbitradas;
	}

	public void setHorasArbitradas(String horasArbitradas) {
		this.horasArbitradas = horasArbitradas;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public void massaJson() {
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader("src/main/java/br/com/edsoft/massaDados/CTLANCA001.json"));
			setLogin((String) jsonObject.get("login"));
			setSenha((String) jsonObject.get("senha"));
			setFilial((String) jsonObject.get("filial"));
			setPlanta((String) jsonObject.get("planta"));
			setNomeProjeto((String) jsonObject.get("nomeProjeto"));
			setNomeDemanda((String) jsonObject.get("nomeDemanda"));
			setTarefa((String) jsonObject.get("tarefa"));
			setHorasArbitradas((String) jsonObject.get("horasArbitradas"));
			setDescricaoAtividade((String) jsonObject.get("descricacaoAtividade"));

//			ConsoleTeste consoleTeste = new ConsoleTeste(driver);			
//			consoleTeste.logInfo(getLogin());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Statement stm; 
	public ResultSet rs; 
	private final String driver = "org.postgresql.Driver"; 
	private String caminho = "jdbc:postgresql://localhost:5432/automacaodb";
	private final String usuario = "postgres";
	private final String password = "eduhit00";
	public static Connection con;

	public void massaBanco() {
		try {
			System.setProperty("jdbc.Drivers", driver); // setar a propriedade do driver
			con = DriverManager.getConnection(caminho, usuario, password);
		} catch (Exception ex) {
			System.out.println("no caminha da conexao:\n" + ex.getMessage());
		}
		try {
			stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY); // verificação de
			rs = stm.executeQuery("select * from  sco where cod='1'");
		} catch (Exception ex) {
			System.out.println("Erro na Query:\n" + ex.getMessage());
		}
		try {
			rs.first();
			setLogin(rs.getString("login"));
			setSenha(rs.getString("senha"));
            setFilial(rs.getString("filial"));
            setPlanta(rs.getString("planta"));
            setNomeProjeto(rs.getString("nomeProjeto"));
            setNomeDemanda(rs.getString("nomeDemanda"));
            setTarefa(rs.getString("tarefa"));
            setHorasArbitradas(rs.getString("horaArbitradas"));
			setDescricaoAtividade(rs.getString("descricaoAtividade"));
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na setgem: " + ex.getStackTrace());
		}
	}
	

	public void LancaTimeExcel(@Param(name = "login") String login, @Param(name = "senha") String senha,
			@Param(name = "filial") String filial, @Param(name = "planta") String planta,
			@Param(name = "nomeProjeto") String nomeProjeto, @Param(name = "nomeDemanda") String nomeDemanda,
			@Param(name = "tarefa") String tarefa, @Param(name = "horasArbitradas") String horasArbitradas,
			@Param(name = "descricacaoAtividade") String descricacaoAtividade) {
		setLogin(login);
//		LoginPage usuario = new LoginPage(driver);
//		usuario.palavraChave().
//		login(getLogin(), senha)
//		.entrar();
//		
//		MenuPage menu = new MenuPage(driver);
//		menu.filialDaSessao(filial)
//		.informoPlanta(planta)
//		.lancaTime();
//		
//		CadastrarTimePage cadastrarPage = new CadastrarTimePage(driver);
//		cadastrarPage.preencherNomeProjeto(nomeProjeto)
//		.preencherNomeDemanda(nomeDemanda)
//		.preencherNomeTarefa(tarefa)
//		.preencherDataAtribuida()
//		.horasArbitradas(horasArbitradas)
//		.descricaoAtividade(descricacaoAtividade);
	}

//	@Ignore
//	public void loginMassaExcel() {
//		FileInputStream fispPlanilha = null;
//		String email = "";
//		String senha = "";
//		try {
//		File file = new File("C:\\Users\\eduardo.matias\\Documents\\eclipce-workspace\\Automacao-PageObject-RSI-timeSheet\\target\\ExcelArv\\massaLoginExcelData.xlsx");
//		fispPlanilha = new FileInputStream(file);
//		XSSFWorkbook workbook = new XSSFWorkbook(fispPlanilha);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		for (Row row : sheet) {
//		if (row.getRowNum() != 0) {
//		break;
//		}
//		for (Cell cell : row) {
//		String conteudoCelula = "";
//		switch (cell.getCellType()) {
//
//		case Cell.CELL_TYPE_STRING:
//		conteudoCelula = cell.getStringCellValue();
//		System.out.println("conteudo = " + conteudoCelula);
//		break;
//
//		case Cell.CELL_TYPE_NUMERIC:
//		System.out.println("" + cell.getStringCellValue());
//		break;
//
//		case Cell.CELL_TYPE_FORMULA:
//		System.out.println("" + cell.getStringCellValue());
//		break;
//		}
//		if (cell.getColumnIndex() == 0) {
//		email = conteudoCelula;
//		} else if (cell.getColumnIndex() == 1) {
//		senha = conteudoCelula;
//		}
//		}
//		}
//		System.out.println("email = " + email + "\nsenha = " + senha);
//		} catch (FileNotFoundException ex) {
//		System.out.println("Erro" + ex.getMessage());
//		} catch (IOException ex) {
//		System.out.println("Erro" + ex.getMessage());
//		}
//	}


}
