package br.com.matrix.subAlgEvo.calc;

import br.com.matrix.evo.padrao.EntidadePadrao;
import br.com.matrix.evo.padrao.FitnessPadrao;
import br.com.matrix.evo.padrao.GerarFitness;
import br.com.matrix.evo.suporte.FitnessEvo;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;

public class ftnCalc implements GerarFitness<EntidadePadrao<SubAlgoritmo<?>, Double, Void>, SubAlgoritmo<?>, Double, Void>{

    private GerenciadorCalc ger;
    
    public ftnCalc(GerenciadorCalc ger) {
	this.ger = ger;
    }
    
    @Override
    public FitnessEvo apply(EntidadePadrao<SubAlgoritmo<?>, Double, Void> arg0) {
	try{
	    return new FitnessPadrao(Double.valueOf(arg0.executar(null).intValue()), 50d);
	}catch(Exception e){
	    System.out.println(e);
	    ger.getLE().remove(arg0);
	}
	return new FitnessPadrao(Double.NEGATIVE_INFINITY);
    }

}
