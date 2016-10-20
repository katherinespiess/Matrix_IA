package br.com.matrix.banco.tabelas.propTabelas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.matrix.banco.tabelas.interfaces.ICampo;
import br.com.matrix.banco.tabelas.interfaces.IColuna;
import br.com.matrix.banco.tabelas.interfaces.ILinha;
import br.com.matrix.banco.tabelas.interfaces.ITabela;

public class Linha implements ILinha {

	private ArrayList<ICampo> campos;

	@Override
	public ITabela getTb() {
		ITabela r = null;

		for (IColuna col : getColunas()) {
			if (col.getTb() != null) {
				r = col.getTb();
				break;
			}
		}

		return r;
	}

	@Override
	public List<IColuna> getColunas() {
		ArrayList<IColuna> colunas = new ArrayList<>();
		if (!getCampos().isEmpty()) {
			for (ICampo c : getCampos()) {
				if (!colunas.contains(c.getColuna()))
					colunas.add(c.getColuna());
			}
		}
		return colunas;
	}

	@Override
	public List<ICampo> getCampos() {
		if (this.campos == null)
			this.campos = new ArrayList<>();
		return this.campos;
	}

	@Override
	public HashMap<IColuna, ICampo> get() {

		HashMap<IColuna, ICampo> retorno = new HashMap<IColuna, ICampo>();

		for (ICampo c : getCampos()) {
			if (c != null && c.getColuna() != null) {
				retorno.put(c.getColuna(), c);
			}
		}

		return retorno;
	}

}
