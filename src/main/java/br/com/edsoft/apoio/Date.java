package br.com.edsoft.apoio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Date {

	private String dataFormatada;
	private String horaFormatada;

	public String getDataFormatada() {
		DateTimeFormatter parserData = DateTimeFormatter.ofPattern("ddMMuuuu");
		LocalDate data = LocalDate.parse("23062017", parserData);
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String dataFormatada = formatterData.format(data); // 23/06/2017
		setDataFormatada(dataFormatada);
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

	public String getHoraFormatada() {

		DateTimeFormatter parserHora = DateTimeFormatter.ofPattern("HHmmss");
		LocalTime hora = LocalTime.parse("212010", parserHora);
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaFormatada = formatterHora.format(hora); // 21:20:10
		setHoraFormatada(horaFormatada);
		return horaFormatada;
	}

	public void setHoraFormatada(String horaFormatada) {
		this.horaFormatada = horaFormatada;
	}

}
