package br.com.matrix.matrix;

import br.com.matrix.banco.tabelas.propTabelas.Linha;

public class SugestaoMatrix {

	String sugestao;
	
	public SugestaoMatrix(Linha l) {
		sugestao = l.getCampos().get(0).getValor().toString();
	}
	
	public String get(){
		return sugestao;
	}
}
