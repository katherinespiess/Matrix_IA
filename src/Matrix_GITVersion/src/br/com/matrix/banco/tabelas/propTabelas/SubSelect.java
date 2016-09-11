package br.com.matrix.banco.tabelas.propTabelas;

import java.util.List;

import br.com.matrix.banco.tabelas.interfaces.ITabela;

public class SubSelect implements ITabela {

	/**
	 * 
	 * @param col
	 * @param where
	 * @return string do subSelect
	 * 
	 * 		- Um subselect só pode devolver um único resultado, caso contrario vai dar erro no comando SQL
	 */
	public String subSelect(Coluna col, String where) {
		StringBuilder cmd = new StringBuilder();
		cmd.append(" ( Select " + col.getTb().getApelido() + "." + col.getNm() + " from " + col.getTb().getNm() + " "
				+ col.getTb().getApelido() + " where " + where + " limit 1) ");

		return cmd.toString();
	}

	@Override
	public List<ColunaFk> getDependecias() {
		return null;
	}

	@Override
	public List<Coluna> getColunas() {
		return null;
	}

	@Override
	public String getNm() {
		return null;
	}

	@Override
	public String getApelido() {
		return null;
	}

}
