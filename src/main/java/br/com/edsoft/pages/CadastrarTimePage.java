package br.com.edsoft.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;

import br.com.edsoft.core.DSL;

public class CadastrarTimePage {

	private WebDriver driver;
	private DSL dsl;

	public CadastrarTimePage(WebDriver driver) {
		this.driver = driver;
		dsl = new DSL(driver);
	}

	public CadastrarTimePage preencherNomeProjeto() {
		dsl.clickName("ctl00$ContentConteudo$ddlProjeto");
		dsl.selecionarCombo("ctl00$ContentConteudo$ddlProjeto", "(7505) - TREINAMENTO HUBB - MODELO E TRABALHO ITAU");
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherNomeDemanda() {
       dsl.clickName("ctl00$ContentConteudo$ddlDemanda");
       dsl.selecionarCombo("ctl00$ContentConteudo$ddlDemanda", "Treinamento Dezembro");		
    	return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherNomeTarefa() {
		dsl.clickName("ctl00$ContentConteudo$ddlTarefa");
        dsl.selecionarCombo("ctl00$ContentConteudo$ddlTarefa", "Treinamento Automação Trainee");		
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage preencherDataAtribuida() {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorformatado = hoje.format(formatador);
		dsl.escreveId("ctl00_ContentConteudo_txtData_Trabalhada", valorformatado);
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage horasArbitradas() {
		dsl.escreveName("ctl00$ContentConteudo$txtHoras","0080");
		return new CadastrarTimePage(driver);
	}

	public CadastrarTimePage descricaoAtividade() {
		dsl.escreveName("ctl00$ContentConteudo$txtObservacao", "Estudando Page Object");
		return new CadastrarTimePage(driver);
	}

}
