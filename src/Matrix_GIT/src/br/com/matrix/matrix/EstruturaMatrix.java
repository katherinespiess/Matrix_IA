package br.com.matrix.matrix;

import java.util.HashMap;
import java.util.List;

import br.com.matrix.banco.Database;
import br.com.matrix.banco.tabelas.Estruturas;
import br.com.matrix.banco.tabelas.interfaces.IArmazenavel;
import br.com.matrix.banco.tabelas.interfaces.ICampo;
import br.com.matrix.banco.tabelas.interfaces.IColuna;
import br.com.matrix.banco.tabelas.interfaces.ILinha;
import br.com.matrix.banco.tabelas.interfaces.ITabela;

public class EstruturaMatrix implements IArmazenavel {

	ILinha val;

	public EstruturaMatrix(int id) {
		val = Database.execute("SELECT * FROM matrix.estruturas where id = " + id).get(0);
	}

	public String getDs() {
		return getCampoPorNm("ds").getValor().toString();		
	}

	@Override
	public ITabela getTb() {
		return Estruturas.get();
	}

	@Override
	public List<IArmazenavel> getDependencias() {
		return null;
	}
	@Override
	public HashMap<IColuna, ICampo> getValoresCampo() {
		return val.get();
	}

}
