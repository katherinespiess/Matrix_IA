package br.com.matrix.aplicacao;

import java.util.HashMap;
import java.util.List;

import br.com.matrix.banco.tabelas.interfaces.IArmazenavel;
import br.com.matrix.banco.tabelas.interfaces.ITabela;
import br.com.matrix.banco.tabelas.propTabelas.Coluna;

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
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HashMap<Coluna, Object> getValores() {
		// TODO Auto-generated method stub
		return null;
	}
}
