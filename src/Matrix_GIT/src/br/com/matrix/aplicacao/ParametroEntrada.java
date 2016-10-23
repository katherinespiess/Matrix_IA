package br.com.matrix.aplicacao;

public class ParametroEntrada {

	private String all;

	public ParametroEntrada(String digitada) {
		all = digitada;
	}

	public String getAll() {
		return all;
	}

	public String getLastWord() {
		return all.split("/s")[all.split("/s").length - 2];
	}
	
	public String getAcWord(){
		return all.split("/s")[all.split("/s").length - 1];
	}
}
