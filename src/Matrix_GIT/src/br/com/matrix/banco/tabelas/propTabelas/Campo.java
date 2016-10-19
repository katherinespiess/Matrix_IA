package br.com.matrix.banco.tabelas.propTabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.AColuna;
import br.com.matrix.banco.tabelas.interfaces.ICampo;

public class Campo implements ICampo {

	private GenColuna coluna;

	private Object valor;

	public AColuna getColuna() {
		return coluna;
	}

	public Object getValor() {
		return valor;
	}

	public Campo(GenColuna coluna, Object valor) {
		this.valor = valor;
		this.coluna = coluna;
	}
}
