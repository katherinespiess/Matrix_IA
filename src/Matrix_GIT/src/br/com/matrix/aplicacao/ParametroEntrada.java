package br.com.matrix.aplicacao;

import java.util.HashMap;
import java.util.List;

import br.com.matrix.banco.tabelas.interfaces.IArmazenavel;
import br.com.matrix.banco.tabelas.interfaces.ICampo;
import br.com.matrix.banco.tabelas.interfaces.IColuna;
import br.com.matrix.banco.tabelas.interfaces.ITabela;

public class ParametroEntrada implements IArmazenavel {

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
	public HashMap<IColuna, Object> getValores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<IColuna, ICampo> getValoresCampo() {
		// TODO Auto-generated method stub
		return null;
	}
}
