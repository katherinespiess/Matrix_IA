package br.com.matrix.banco.tabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.GenColuna;
import br.com.matrix.banco.tabelas.propTabelas.ColunaFk;

public class Palavras extends ATabela {

	private Palavras() {
		super("Palavras", "pa");

		this.getDependecias().add(new ColunaFk(Pontuacoes.get().getId(), "id_p", this));
		
		this.getColunas().add(new GenColuna("id", this));
		this.getColunas().add(new GenColuna("ds", this));
		this.getColunas().addAll(getDependecias());
	}

	/**
	 * referência da tabela
	 */
	private static Palavras ref;

	public static Palavras get() {
		return ref == null ? ref = new Palavras() : ref;
	}

}