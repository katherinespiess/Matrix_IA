package br.com.matrix.banco.tabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.Coluna;
import br.com.matrix.banco.tabelas.propTabelas.ColunaFk;

public class Palavras extends ATabela {

	private Palavras() {
		super("Palavras", "pa");

		this.getDependecias().add(new ColunaFk(Pontuacoes.get().getId(), "id_p", this));
		
		this.getColunas().add(new Coluna("id", this));
		this.getColunas().add(new Coluna("ds", this));
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