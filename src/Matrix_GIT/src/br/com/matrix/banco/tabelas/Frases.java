package br.com.matrix.banco.tabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.GenColuna;

public class Frases extends ATabela {

	private Frases() {
		super("Frases", "fr");

		getColunas().add(new GenColuna("id", this));
		getColunas().add(new GenColuna("ds", this));

	}

	/**
	 * referência da tabela
	 */
	private static Frases ref;

	public static Frases get() {
		return (ref == null) ? ref = new Frases() : ref;
	}

}
