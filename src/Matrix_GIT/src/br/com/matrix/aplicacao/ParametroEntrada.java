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
		String s = all.split("\\s+").length>1?all.split("\\s+")[all.split("\\s+").length - 2]:"";
		return s;
	}
	
	public String getAcWord(){
		String s = all.split("\\s")[all.split("\\s").length - 1];
		return s;
	}
}
