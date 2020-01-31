package br.com.edsoft.telas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.apoio.Date;
import br.com.edsoft.core.BasePage;

public class CadastrarTimePage {

	private WebDriver driver;
	private BasePage basePage;
	CarregaMassa dadosCarregados = new CarregaMassa();

	public CadastrarTimePage(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage(driver);
//		dadosCarregados.massaJson();
		dadosCarregados.massaBanco();
	}
	
	public void preencherLancaHoras() {
		preencherNomeProjeto(dadosCarregados.getNomeProjeto());
		preencherNomeDemanda(dadosCarregados.getNomeDemanda());
		preencherNomeTarefa(dadosCarregados.getTarefa());
		preencherDataAtribuida();
		horasArbitradas(dadosCarregados.getHorasArbitradas());
		descricaoAtividade(dadosCarregados.getDescricaoAtividade());
	}

	public CadastrarTimePage preencherNomeProjeto(String nomeProjeto) {
		basePage.clicarName("ctl00$ContentConteudo$ddlProjeto");
		basePage.selecionarCombo("ctl00$ContentConteudo$ddlProjeto", nomeProjeto);
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"nome do projeto: "+nomeProjeto);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherNomeDemanda(String nomeDemanda) {
       basePage.clicarName("ctl00$ContentConteudo$ddlDemanda");
       basePage.selecionarCombo("ctl00$ContentConteudo$ddlDemanda", nomeDemanda);
       Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"nome demanda: "+nomeDemanda);
    	return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherNomeTarefa(String tarefa) {
		basePage.clicarName("ctl00$ContentConteudo$ddlTarefa");
        basePage.selecionarCombo("ctl00$ContentConteudo$ddlTarefa", tarefa);
        Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"tarefa: "+tarefa);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherDataAtribuida() {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String valorformatado = hoje.format(formatador);
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"data há ser lançada: "+valorformatado);
		basePage.digitaTextoId("ctl00_ContentConteudo_txtData_Trabalhada", valorformatado);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage horasArbitradas(String horasArbitradas) {
		basePage.digitaTextoName("ctl00$ContentConteudo$txtHoras",horasArbitradas);
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"horas arbitradas: "+horasArbitradas);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage descricaoAtividade(String descricaoAtividade) {
		basePage.digitaTextoName("ctl00$ContentConteudo$txtObservacao", descricaoAtividade);
		Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"descrição da atividade: "+descricaoAtividade);
		return new CadastrarTimePage(driver);
	}

}
