package br.com.matrix.banco.tabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.GenColuna;

public class Datas extends ATabela {

	private Datas() {
		super("datas", "dt");

		getColunas().add(new GenColuna("id", this));
		getColunas().add(new GenColuna("dt", this));
	}

	/**
	 * referência da tabela
	 */
	private static Datas ref;

	public static Datas get() {
		return (ref == null) ? ref = new Datas() : ref;
	}
}
