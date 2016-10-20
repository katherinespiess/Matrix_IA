package br.com.matrix.banco.tabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.GenColuna;
import br.com.matrix.banco.tabelas.propTabelas.ColunaFk;

public class Sugestores_has_Sugestores extends ATabela {

	private Sugestores_has_Sugestores() {
		super("Sugestores_has_Sugestores", "shs");

		
		getDependecias().add(new ColunaFk(Sugestores.get().getId(), "id_s", this));
		getDependecias().add(new ColunaFk(Sugestores.get().getId(), "id_s_pai", this));
		
		getColunas().add(new GenColuna("id", this));
		getColunas().addAll(getDependecias());
	}

	/**
	 * referência da tabela
	 */
	private static Sugestores_has_Sugestores ref;

	public static Sugestores_has_Sugestores get() {
		return (ref == null) ? ref = new Sugestores_has_Sugestores() : ref;
	}

}
