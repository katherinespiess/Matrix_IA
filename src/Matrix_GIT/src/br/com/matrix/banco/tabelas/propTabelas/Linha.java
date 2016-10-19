package br.com.matrix.banco.tabelas.propTabelas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.matrix.banco.tabelas.classesAbstratas.ATabela;
import br.com.matrix.banco.tabelas.interfaces.IColuna;
import br.com.matrix.banco.tabelas.interfaces.ILinha;

public class Linha implements ILinha {

	private ATabela tb;

	private ArrayList<IColuna> colunas;
	
	private ArrayList<Campo> campos;

	@Override
	public ATabela getTb() {

		return this.tb;
	}

	@Override
	public List<IColuna> getColunas() {
		if (this.colunas == null)
			this.colunas = new ArrayList<>();
		return this.colunas;
	}
	
	public List<Campo> getCampos(){
		if (this.campos == null)
			this.campos =  new ArrayList<>();
		return this.campos;
	}
	
	@Override
	public HashMap<IColuna, Campo> get() {
		
		HashMap<IColuna, Campo> retorno = new HashMap<IColuna, Campo>();
		
		for (Campo c : getCampos()) {
			retorno.put(c.getColuna(), c);
		}

		return retorno;
	}

	

}
