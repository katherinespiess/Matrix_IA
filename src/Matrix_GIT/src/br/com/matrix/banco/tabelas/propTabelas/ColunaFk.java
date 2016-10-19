package br.com.matrix.banco.tabelas.propTabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;

public class ColunaFk extends GenColuna{

	public ColunaFk(GenColuna colunaRef,String nm, ATabela tabela) {
		super(nm, tabela);
		
		this.colunaRef = colunaRef;
	}
	
	private GenColuna colunaRef;

	public GenColuna getColunaRef() {
		return colunaRef;
	}
}
