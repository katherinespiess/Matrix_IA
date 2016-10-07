package br.com.matrix.subAlgEvo.calc;

import java.util.List;

import br.com.matrix.evo.padrao.EntidadePadrao;
import br.com.matrix.evo.padrao.GerarFitness;
import br.com.matrix.evo.suporte.Executar;
import br.com.matrix.subAlgEvo.EntidadeSubAlgEvo;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;

public class EntidadeCalc extends EntidadeSubAlgEvo<Double, Void> {

    public EntidadeCalc(Executar<SubAlgoritmo<?>, Void, Double> exe,
	    GerarFitness<EntidadePadrao<SubAlgoritmo<?>, Double, Void>, SubAlgoritmo<?>, Double, Void> ftn,
	    List<SubAlgoritmo<?>> gen, List<SubAlgoritmo<?>> genPool) {
	super(exe, ftn, gen, genPool);
    }
    
    public EntidadeCalc(Executar<SubAlgoritmo<?>, Void, Double> exe,
	    GerarFitness<EntidadePadrao<SubAlgoritmo<?>, Double, Void>, SubAlgoritmo<?>, Double, Void> ftn,
	    List<SubAlgoritmo<?>> genStart, List<SubAlgoritmo<?>> genPool, int qtGenes) {
	super(exe, ftn, genPool, genPool, qtGenes);
    }

    public boolean isFinalizar(){
	 resetExecutado();
	 boolean r = executar(null) == 5d;//temporário
	 resetExecutado();
	 return r;
    }
    
    

}
