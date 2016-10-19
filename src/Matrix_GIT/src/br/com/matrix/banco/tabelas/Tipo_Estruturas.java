package br.com.matrix.banco.tabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.GenColuna;

public class Tipo_Estruturas extends ATabela {

	private Tipo_Estruturas() {
		super("Tipo_Estruturas", "te");

		getColunas().add(new GenColuna("id", this));
		getColunas().add(new GenColuna("ds", this));

	}

	/**
	 * referência da tabela
	 */
	private static Tipo_Estruturas ref;

	public static Tipo_Estruturas get() {
		return (ref == null) ? ref = new Tipo_Estruturas() : ref;
	}

}
