package br.com.matrix.matrix;

import java.util.ArrayList;
import java.util.function.Function;

public class CondicaoAgrupamentoMatrix implements Function<ArrayList<Sugestor>, ArrayList<ArrayList<Sugestor>>> {

	@Override
	public ArrayList<ArrayList<Sugestor>> apply(ArrayList<Sugestor> arg0) {
		ArrayList<ArrayList<Sugestor>> r = new ArrayList<ArrayList<Sugestor>>();
		ArrayList<Sugestor> g;
		for (int i = 0; i < arg0.size(); i += 2) {
			g = new ArrayList<Sugestor>();
			g.add(arg0.get(i));
			g.add(arg0.get(i + 1));
			r.add(g);
		}
		return r;
	}

}
