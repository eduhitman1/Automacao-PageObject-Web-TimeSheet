package br.com.edsoft.util.leitorPdf;

public class Leitor {
	public static void main(String[] args) {
		int i;
		String caminho = "src/main/java/br/com/edsoft/util/LeitorPdf/teste.pdf";
		String texto = UtilTexto.extraiTextoDoPDF(caminho);
		
		
		
		System.out.println(texto.split(System.lineSeparator())+"teste");
	}
}
