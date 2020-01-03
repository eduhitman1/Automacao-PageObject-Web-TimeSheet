package br.com.edsoft.telas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import br.com.edsoft.apoio.CarregaMassa;
import br.com.edsoft.core.DSL;

public class CadastrarTimePage {

	private WebDriver driver;
	private DSL dsl;
	CarregaMassa dadosCarregados = new CarregaMassa();

	public CadastrarTimePage(WebDriver driver) {
		this.driver = driver;
		dsl = new DSL(driver);
		dadosCarregados.massaJson();
	}
	
	
	
	public void preencherLancaHoras() {
		preencherNomeProjeto(dadosCarregados.getNomeProjeto());
		preencherNomeDemanda(dadosCarregados.getNomeDemanda());
		preencherNomeTarefa(dadosCarregados.getTarefa());
		preencherDataAtribuida();
		horasArbitradas(dadosCarregados.getHorasArbitradas());
		
	}

	
	

	public CadastrarTimePage preencherNomeProjeto(String nomeProjeto) {
		dsl.clickName("ctl00$ContentConteudo$ddlProjeto");
		dsl.selecionarCombo("ctl00$ContentConteudo$ddlProjeto", nomeProjeto);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherNomeDemanda(String nomeDemanda) {
       dsl.clickName("ctl00$ContentConteudo$ddlDemanda");
       dsl.selecionarCombo("ctl00$ContentConteudo$ddlDemanda", nomeDemanda);		
    	return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherNomeTarefa(String tarefa) {
		dsl.clickName("ctl00$ContentConteudo$ddlTarefa");
        dsl.selecionarCombo("ctl00$ContentConteudo$ddlTarefa", tarefa);		
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherDataAtribuida() {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorformatado = hoje.format(formatador);
		dsl.escreveId("ctl00_ContentConteudo_txtData_Trabalhada", valorformatado);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage horasArbitradas(String horasArbitradas) {
		dsl.escreveName("ctl00$ContentConteudo$txtHoras",horasArbitradas);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage descricaoAtividade(String descricaoAtividade) {
		dsl.escreveName("ctl00$ContentConteudo$txtObservacao", descricaoAtividade);
		return new CadastrarTimePage(driver);
	}

}
