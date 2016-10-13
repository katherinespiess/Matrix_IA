package br.com.matrix.subAlgEvo;

import java.util.List;
import java.util.Random;

import br.com.matrix.evo.suporte.CodigoGenEvo;
import br.com.matrix.evo.suporte.Mutar;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;

public class MutarSubAlg implements Mutar<SubAlgoritmo<?>> {

    List<SubAlgoritmo<?>> genPool;

    public MutarSubAlg(List<SubAlgoritmo<?>> genPool) {
	this.genPool = genPool;
    }

    @Override
    public CodigoGenEvo<SubAlgoritmo<?>> apply(CodigoGenEvo<SubAlgoritmo<?>> t) {
	Random r = new Random();

	boolean alterou = false;
	if (!alterou) {
	    int indexStart = r.nextInt(t.size());

	    for (int i = 0; i < t.size(); i++) {
		int index = (i + indexStart) % t.size();

		SubAlgoritmo<?> sa = t.get(index);

		for (SubAlgoritmo<?> saImp : genPool) {
		    if (sa.getMetaInfo().equals(saImp.getMetaInfo()) && !sa.getClass().equals(saImp.getClass())) {
			t.set(t.indexOf(sa), saImp);
			alterou = true;
		    }
		}
	    }
	}
	if (!alterou){
	    for (int indexUm = 0; indexUm < t.size()-1; indexUm++) {
		for (int indexDois = indexUm+1; indexDois < t.size(); indexDois++) {
		    if (t.get(indexUm).getMetaInfo().equals(t.get(indexDois).getMetaInfo()) && !t.get(indexUm).getClass().equals(t.get(indexDois).getClass())){
			SubAlgoritmo<?> temp = t.get(indexUm);
			t.set(indexUm, t.get(indexDois));
			t.set(indexDois, temp);
			alterou = true;
		    }
		}
	    }
	}

	return t;

    }

}
