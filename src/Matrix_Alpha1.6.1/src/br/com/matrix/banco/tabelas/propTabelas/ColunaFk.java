package br.com.matrix.banco.tabelas.propTabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;

public class ColunaFk extends Coluna{

	public ColunaFk(Coluna colunaRef,String nm, ATabela tabela) {
		super(nm, tabela);
		
		this.colunaRef = colunaRef;
	}
	
	private Coluna colunaRef;

	public Coluna getColunaRef() {
		return colunaRef;
	}
}
