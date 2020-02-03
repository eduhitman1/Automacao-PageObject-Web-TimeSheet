package br.com.edsoft.util.leitorPdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class UtilTexto {
	/**
	 * Le o conteudo (texto) de um arquivo pdf
	 *
	 */
	public static String extraiTextoDoPDF(String caminho) {
		int i;
		PDDocument pdfDocument = null;
		try {
			pdfDocument = PDDocument.load(caminho);
			PDFTextStripper stripper = new PDFTextStripper();
			String texto = stripper.getText(pdfDocument);
			
			String[] docxLines = texto.split(System.lineSeparator());
			for (String line : docxLines) {
//				lines.add(line);
			}
			
			
			return texto;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (pdfDocument != null)
				try {
					pdfDocument.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		}
	}
}
