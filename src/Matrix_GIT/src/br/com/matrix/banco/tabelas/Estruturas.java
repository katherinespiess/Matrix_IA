package br.com.matrix.banco.tabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.GenColuna;
import br.com.matrix.banco.tabelas.propTabelas.ColunaFk;

public class Estruturas extends ATabela {
	
	private Estruturas() {
		super("Estruturas","es");

		getDependecias().add(new ColunaFk(new GenColuna("id", Tipo_Estruturas.get()) ,"id_t", this));

		getColunas().add(new GenColuna("id",this));
		getColunas().add(new GenColuna("ds", this));
		getColunas().addAll(getDependecias());
	}

	/**
	 * referência da tabela
	 */
	private static Estruturas ref;

	public static Estruturas get() {
		return (ref == null) ? ref = new Estruturas() : ref;
	}
	
}
