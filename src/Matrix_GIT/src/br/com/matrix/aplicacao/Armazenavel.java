package br.com.matrix.aplicacao;

import java.util.HashMap;
import java.util.List;

import br.com.matrix.banco.tabelas.interfaces.IArmazenavel;
import br.com.matrix.banco.tabelas.interfaces.ICampo;
import br.com.matrix.banco.tabelas.interfaces.IColuna;
import br.com.matrix.banco.tabelas.interfaces.ITabela;

public class Armazenavel implements IArmazenavel{

	private HashMap<IColuna, ICampo> valoresCampo;
	
	
	public Armazenavel(List<ICampo> campos){
		
		this.valoresCampo = new HashMap<>();
		
		for(ICampo campo : campos)
			if(campo != null)
				this.valoresCampo.put(campo.getColuna(), campo);
	}
	
	@Override
	public ITabela getTb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IArmazenavel> getDependencias() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HashMap<IColuna, ICampo> getValoresCampo() {
		
		return this.valoresCampo;
	}

}
