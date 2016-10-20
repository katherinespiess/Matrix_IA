package br.com.matrix.banco.tabelas.interfaces;

import java.util.HashMap;
import java.util.List;

public interface ILinha {

	public ITabela getTb();
	
	public List<IColuna> getColunas();
	public List<ICampo> getCampos();
	public HashMap<IColuna, ICampo> get();
	
}
