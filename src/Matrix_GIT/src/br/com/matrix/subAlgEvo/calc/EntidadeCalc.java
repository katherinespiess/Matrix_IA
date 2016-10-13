package br.com.matrix.subAlgEvo.calc;

import java.util.List;

import br.com.matrix.subAlgEvo.EntidadeSubAlgEvo;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;

public class EntidadeCalc extends EntidadeSubAlgEvo<Double, Void> {

    public EntidadeCalc(List<SubAlgoritmo<?>> gen, List<SubAlgoritmo<?>> genPool, GerenciadorCalc ger) {
	super(new exeCalc(ger), new ftnCalc(ger), gen, genPool, ger);
    }

    public EntidadeCalc(List<SubAlgoritmo<?>> genStart, List<SubAlgoritmo<?>> genPool,
	    int qtGenes, GerenciadorCalc ger) {
	super(new exeCalc(ger), new ftnCalc(ger), genPool, genPool, qtGenes, ger);
    }
}
