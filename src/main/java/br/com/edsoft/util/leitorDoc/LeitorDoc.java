package br.com.edsoft.util.leitorDoc;

import java.io.FileInputStream;

import javax.swing.JOptionPane;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class LeitorDoc {

	private void readPDFDocument() {
//		try {
//			FileInputStream fs = new FileInputStream(f);
//			String text = "";
//			PDFParser parser = new PDFParser(fs);
//			parser.parse();
//			COSDocument cosDoc = parser.getDocument();
//			PDFTextStripper pdfStripper = new PDFTextStripper();
//			PDDocument pdDoc = new PDDocument(cosDoc);
//			text = pdfStripper.getText(pdDoc);
//			String[] docxLines = text.split(System.lineSeparator());
//
//			for (String line : docxLines) {
////				docxLines.add(line);
//			}
//			fs.close();
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Fehler in readPDFDocument", "Fehler", JOptionPane.ERROR_MESSAGE);
//			e.printStackTrace();
//		}
	}

}
