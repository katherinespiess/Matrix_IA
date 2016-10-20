package br.com.matrix.matrix;

import br.com.matrix.banco.tabelas.interfaces.ILinha;

public class SugestaoMatrix {

	String sugestao;
	
	public SugestaoMatrix(ILinha l) {
		sugestao = l.getCampos().get(0).getValor().toString();
	}
	
	public String get(){
		return sugestao;
	}
}
