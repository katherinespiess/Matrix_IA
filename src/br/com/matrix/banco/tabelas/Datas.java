package br.com.matrix.banco.tabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.Coluna;

public class Datas extends ATabela {

	private Datas() {
		super("datas", "dt");

		getColunas().add(new Coluna("id", this));
		getColunas().add(new Coluna("dt", this));
	}

	/**
	 * referência da tabela
	 */
	private static Datas ref;

	public static Datas get() {
		return (ref == null) ? ref = new Datas() : ref;
	}
}
