package br.com.matrix.banco.tabelas.propTabelas;

import br.com.matrix.banco.tabelas.classesAbstratas.AColuna;
import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;

public class GenColuna extends AColuna{

	public GenColuna(String nm, ATabela tb) {
		super(nm, tb);
	}
	
	public String getApNm(){
		return getTb().getApelido()+"."+getNm();
	}

}
