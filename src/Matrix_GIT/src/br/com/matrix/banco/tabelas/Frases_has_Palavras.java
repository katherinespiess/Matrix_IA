package br.com.matrix.banco.tabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.GenColuna;
import br.com.matrix.banco.tabelas.propTabelas.ColunaFk;

public class Frases_has_Palavras extends ATabela {

	private Frases_has_Palavras() {
		super("Frases_has_Palavras", "fhp");

		getDependecias().add(new ColunaFk(Frases.get().getId(), "id_f", this));
		getDependecias().add(new ColunaFk(Palavras.get().getId(), "id_p", this));
		
		getColunas().add(new GenColuna("id", this));
		getColunas().addAll(getDependecias());
	}

	/**
	 * referência da tabela
	 */
	private static Frases_has_Palavras ref;

	public static Frases_has_Palavras get() {
		return (ref == null) ? ref = new Frases_has_Palavras() : ref;
	}

}
