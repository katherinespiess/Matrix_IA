package br.com.matrix.matrix;

import java.util.HashMap;
import java.util.List;

import br.com.matrix.banco.Database;
import br.com.matrix.banco.tabelas.Estruturas;
import br.com.matrix.banco.tabelas.interfaces.IArmazenavel;
import br.com.matrix.banco.tabelas.interfaces.IColuna;
import br.com.matrix.banco.tabelas.interfaces.ITabela;
import br.com.matrix.banco.tabelas.propTabelas.Linha;

public class EstruturaMatrix implements IArmazenavel {

	Linha val;

	public EstruturaMatrix(int id) {
		val = Database.execute("SELECT * FROM matrix.estruturas where id = " + id).get(0);
	}

	public String getDs() {
		String r = null;
		for (IColuna c : val.get().keySet()) {
			if (c.getNm().equals("ds")){
				r = val.get().get(c).getValor().toString();
				break;
			}
		}
		return r;
	}

	@Override
	public ITabela getTb() {
		return Estruturas.get();
	}

	@Override
	public List<IArmazenavel> getDependencias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId() {
		String r = null;
		for (IColuna c : val.get().keySet()) {
			if (c.getNm().equals("id")){
				r = val.get().get(c).getValor().toString();
				break;
			}
		}
		return Integer.valueOf(r);
	}

	@Override
	public HashMap<IColuna, Object> getValores() {
		HashMap<IColuna, Object> r = new HashMap<IColuna, Object>();
		
		for (IColuna c : val.get().keySet()) 
			r.put(c, val.get().get(c).getValor());		
		
		return r;
	}

	public String toString() {
		return val.toString();
	}

}
