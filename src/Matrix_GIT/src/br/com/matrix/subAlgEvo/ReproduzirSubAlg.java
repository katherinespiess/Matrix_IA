package br.com.matrix.subAlgEvo;

import java.util.Random;

import br.com.matrix.evo.EntidadeEvo;
import br.com.matrix.evo.suporte.Fabricar;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;
import br.com.matrix.evo.suporte.reproduzir;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;

public class ReproduzirSubAlg<R, P> implements reproduzir<br.com.matrix.subAlgoritmo.SubAlgoritmo<?>, R, P> {

    Fabricar<SubAlgoritmo<?>, R, P> fabrica;

    public ReproduzirSubAlg(Fabricar<SubAlgoritmo<?>, R, P> fabrica) {
	this.fabrica = fabrica;
    }

    @Override
    public GrupoEntidadesEvo<SubAlgoritmo<?>, R, P> apply(GrupoEntidadesEvo<SubAlgoritmo<?>, R, P> t, Integer u) {
	GrupoEntidadesEvo<SubAlgoritmo<?>, R, P> result = new GrupoEntidadesEvo<>();

	for (int i = 0; i < u; i++) {
	    result.add(apply(t));
	}

	return result;
    }

    private EntidadeEvo<SubAlgoritmo<?>, R, P> apply(GrupoEntidadesEvo<SubAlgoritmo<?>, R, P> t) {
	Random r = new Random();

	EntidadeSubAlgEvo<R, P> result = (EntidadeSubAlgEvo<R, P>) fabrica.get();

	for (int indexQtGenes = 0; indexQtGenes < t.getFirst().getCG().size(); indexQtGenes++) {
	    int indexImp = 0;
	    while (result.getCG().size() < indexQtGenes+1) {
		if (r.nextBoolean()) {
		    SubAlgoritmo<?> temp = t.get(indexImp % t.size()).getCG().get(indexQtGenes);
		    if (result.getCG().size() > 0) {
			boolean temRetornoRequerido = result.getCG().get(indexQtGenes-1).getMetaInfo().getParam() == null
				|| result.getCG().get(indexQtGenes-1).getMetaInfo().getParam().isEmpty() || (r.nextInt(10) == 1);
			if (!temRetornoRequerido)
			    for (MetaInfoAssinatura m : result.getCG().get(indexQtGenes-1).getMetaInfo().getParam()) {
				if (m.getReturnTp().equals(temp.getMetaInfo().getReturnTp())) {
				    temRetornoRequerido = true;
				    break;
				}
			    }
			if (temRetornoRequerido)
			    result.getCG().add(temp);
		    }else{
		    	result.getCG().add(t.get(indexImp % t.size()).getCG().get(indexQtGenes));
		    }
		} else {
		    indexImp++;
		}
	    }
	}
	
	result.padronizaCG();
	
	return result;

    }

}
