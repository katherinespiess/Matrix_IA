package br.com.matrix.subAlgEvo.calc;

import br.com.matrix.evo.suporte.CodigoGenEvo;
import br.com.matrix.evo.suporte.Executar;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;

public class exeCalc implements Executar<SubAlgoritmo<?>, Void, Double> {

    private GerenciadorCalc ger;

    public exeCalc(GerenciadorCalc ger) {
	this.ger = ger;
    }

    @Override
    public Double apply(CodigoGenEvo<SubAlgoritmo<?>> arg0, Void arg1) {
	Double result = null;
	
	try{	
	for (SubAlgoritmo<?> sa : arg0)
	    sa.resetExecutado();
	int index = 0;
	while (index < arg0.size() && result == null) {
	    if (!arg0.get(index).isExecutado()) {
		arg0.get(index).executar();
		result = Double.valueOf(arg0.get(index).retornar().toString());
	    }
	    index++;
	}
	}catch(Exception e){
	    for (int i = 0; i < ger.getLE().size(); i++) {
		if (ger.getLE().get(i).getCG().equals(arg0)){
		    ger.getLE().remove(i);
		    i--;
		}
	    }
	}
	if (result == null || result.isNaN() || result.isInfinite())
	    result = new Double(0d);

	return result;
    }

}