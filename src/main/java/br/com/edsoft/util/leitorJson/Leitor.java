package br.com.edsoft.util.leitorJson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Leitor {
	
	 public static void main(String[] args) {
		 String login;
		 String senha;
		 String filial;
		 String planta;
		 String nomeProjeto;
		 String nomeDemanda;
		 String tarefa;
		 String horasArbitradas;
		 String descricaoAtividade;
		 
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader("src/main/java/br/com/edsoft/massaDados/CTLANCA001.json"));
			login = ((String) jsonObject.get("login"));
			senha = ((String) jsonObject.get("senha"));
			filial = ((String) jsonObject.get("filial"));
			planta =((String) jsonObject.get("planta"));
			nomeProjeto = ((String) jsonObject.get("nomeProjeto"));
			nomeDemanda = ((String) jsonObject.get("nomeDemanda"));
			tarefa = ((String) jsonObject.get("tarefa"));
			horasArbitradas =((String) jsonObject.get("horasArbitradas"));
			descricaoAtividade = ((String) jsonObject.get("descricacaoAtividade"));

			System.out.printf(
					"Login: %s\nSenha: %s\nFilial: %s\nPlanta: %s\nNome do Projeto: %s\nNome do Demanda: %s\nNome da Tarefa: %s\nHoras Arbitradas: %s\nDescrição de Atividade: %s \n",
					login, 
					senha, 
					filial, 
					planta, 
					nomeProjeto, 
					nomeDemanda, 
					tarefa,
					horasArbitradas, 
					descricaoAtividade);
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}
