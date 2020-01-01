package br.com.edsoft.func.LeitorPdf;

public class Leitor {

	
	public static void main(String[] args) {
		String caminho = "src/main/java/br/com/edsoft/func/LeitorPdf/teste.pdf";
		String texto = UtilTexto.extraiTextoDoPDF(caminho);
		System.out.println(texto);
		}
		}
	
	

