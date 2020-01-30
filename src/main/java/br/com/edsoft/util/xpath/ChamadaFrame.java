package br.com.edsoft.util.xpath;

public class ChamadaFrame {

	public static void main(String[] args) {
		
		ElementoWeb elemento = FrameExemplo.recuperaElemento("div", "class", "xpto");
		
		elemento.escrever("xxxxxx");
	}
	
	
}
