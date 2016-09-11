package br.com.matrix.banco.tabelas;


import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.Coluna;

public class Pontuacoes extends ATabela {

	private Pontuacoes() {
		super("Pontuacoes", "pon");
		
		getColunas().add(new Coluna("id", this));
		getColunas().add(new Coluna("ds", this));
		
	}

	/**
	 * referência da tabela
	 */
	private static Pontuacoes ref;

	
	public static Pontuacoes get(){
		return ref == null ? ref = new Pontuacoes() : ref;
	}

	
}
