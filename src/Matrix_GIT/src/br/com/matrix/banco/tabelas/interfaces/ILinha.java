package br.com.matrix.banco.tabelas.interfaces;

import java.util.HashMap;
import java.util.List;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.propTabelas.Campo;

public interface ILinha {

	public ATabela getTb();
	
	public List<IColuna> getColunas();
	
	public HashMap<IColuna, Campo> get();
	
}
