package br.com.edsoft.suport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LendoXLSX {
	public static void main(String[] args) {
		FileInputStream fispPlanilha = null;
		try {
			File file = new File("\\target\\ExcelArv\\massaLoginExcelData.xlsx");
			fispPlanilha = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fispPlanilha);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_STRING:
						System.out.println("" + cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_NUMERIC:
						System.out.println("" + cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_FORMULA:
						System.out.println("" + cell.getStringCellValue());
						break;
					}
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Erro" + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Erro" + ex.getMessage());
		}
	}

}
