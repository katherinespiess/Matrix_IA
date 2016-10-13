package br.com.matrix.subAlgEvo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import br.com.matrix.evo.suporte.CodigoGenEvo;
import br.com.matrix.evo.suporte.PadronizarCodigoGenetico;
import br.com.matrix.subAlgoritmo.Entrada;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;
import br.com.matrix.subAlgoritmo.variavel.AtribuicaoVariavel;
import br.com.matrix.subAlgoritmo.variavel.Variavel;

public class PadronizarSubAlg implements PadronizarCodigoGenetico<SubAlgoritmo<?>> {

    private List<SubAlgoritmo<?>> genUtilizavel;

    public PadronizarSubAlg(List<SubAlgoritmo<?>> genesDisp) {
	this.genUtilizavel = genesDisp;
    }

    private int isSupDuplicado(Supplier<?> s, CodigoGenEvo<SubAlgoritmo<?>> t) {
	int cv = 0;
	int ca = 0;

	for (SubAlgoritmo<?> sa : t) {
	    if (sa instanceof AtribuicaoVariavel<?> && ((AtribuicaoVariavel<?>) sa).getSup().equals(s))
		ca++;

	    if (sa instanceof Variavel<?> && ((Variavel<?>) sa).getSup().equals(s))
		cv++;
	}

	return !(cv >= 2 && ca >= 1)?!(ca>=1)?2:3:1;
    }

    private CodigoGenEvo<SubAlgoritmo<?>> balancearVar(CodigoGenEvo<SubAlgoritmo<?>> t) {

	for (int i = 0; i < t.size(); i++) {
	    SubAlgoritmo<?> sa = t.get(i);
	    if (sa instanceof Variavel<?>) {
		Variavel<?> var = (Variavel<?>) sa;
		if (isSupDuplicado(var.getSup(), t) == 2) {
		    t.add(0, var.getAtVar());
		    i = -1;
		    continue;
		}
	    }
	    if (sa instanceof AtribuicaoVariavel<?>) {
		AtribuicaoVariavel<?> atVar = (AtribuicaoVariavel<?>) sa;
		while (isSupDuplicado(atVar.getSup(), t)==3) {
		    t.add(atVar.getVar());
		    i++;
		}

	    }
	}
	return t;
    }

    private <A> void trancreverList(List<A> listaA, List<A> listaB) {
	listaA.clear();
	for (A item : listaB) {
	    listaA.add(item);
	}
    }

    private <A> void trancreverList(List<A> listaA, List<A> listaB, List<A> listaC) {
	trancreverList(listaA, listaB);
	for (A item : listaC) {
	    listaA.add(item);
	}
    }

    private boolean tentarPreparar(SubAlgoritmo<?> entidade, List<SubAlgoritmo<?>> param) {
	try {
	    entidade.preparar(param);
	    return entidade.isPreparado();
	} catch (IllegalArgumentException e) {
	    return false;
	}
    }

    private boolean isPrecisaParam(SubAlgoritmo<?> entidade) {
	return entidade.getMetaInfo().getParam() != null && !entidade.getMetaInfo().getParam().isEmpty();
    }

    private boolean isPreparadoLista(List<SubAlgoritmo<?>> l) {
	for (SubAlgoritmo<?> sa : l) {
	    if (!sa.isPreparado())
		return false;
	}
	return true;
    }

    private List<SubAlgoritmo<?>> getSubAlgsChamados(List<SubAlgoritmo<?>> from, SubAlgoritmo<?> chamador) {
	List<SubAlgoritmo<?>> r = new ArrayList<>();
	for (int i = 0; i < from.size(); i++)
	    if (from.get(i).isChamado(chamador))
		r.add(from.get(i));

	return r;
    }

    private void verificaEntrada(CodigoGenEvo<SubAlgoritmo<?>> codGen) {
	while (codGen.get(0) instanceof Entrada<?>) {
	    SubAlgoritmo<?> a = codGen.get(0);
	    codGen.remove(a);
	    codGen.add(a);
	}
    }
    @Override
    public CodigoGenEvo<SubAlgoritmo<?>> apply(CodigoGenEvo<SubAlgoritmo<?>> codGen) {

	balancearVar(codGen);
	verificaEntrada(codGen);

	List<SubAlgoritmo<?>> paramDisp = new ArrayList<>();
	List<SubAlgoritmo<?>> tempFora = new ArrayList<>();
	List<SubAlgoritmo<?>> param = new ArrayList<>();

	for (int indexMor = codGen.size() - 1; indexMor >= 0; indexMor--) {
	    if (isPrecisaParam(codGen.get(indexMor))) {
		trancreverList(tempFora, getSubAlgsChamados(paramDisp, codGen.get(indexMor)));
		paramDisp.removeAll(tempFora);

		if (genUtilizavel.size() > 0 || true) {
		    int controleCiclo = 0;
		    int indexImportacaoGene = -1;
		    while (indexImportacaoGene < genUtilizavel.size()) {
			indexImportacaoGene++;
			for (int indexTentPrep = paramDisp.size(); indexTentPrep >= 0; indexTentPrep--) {
			    trancreverList(param, genUtilizavel.subList(0, indexImportacaoGene),
				    paramDisp.subList(0, indexTentPrep));
			    if (isPreparadoLista(param) && tentarPreparar(codGen.get(indexMor), param)) {
				controleCiclo = -1;
				break;
			    }
			}

			if (controleCiclo == -1)
			    break;

			if (genUtilizavel.size() == indexImportacaoGene && controleCiclo < indexImportacaoGene) {
			    indexImportacaoGene = 0;
			    controleCiclo++;
			    SubAlgoritmo<?> a = genUtilizavel.get(0);
			    genUtilizavel.remove(0);
			    genUtilizavel.add(a);
			}
		    }
		    if (controleCiclo == -1) {
			paramDisp.removeAll(param);
			param.removeAll(codGen);
			codGen.addAll(indexMor + 1, param);
			genUtilizavel.removeAll(param);
		    } else {
			throw new IllegalArgumentException(
				"Os genes disponibilizados para fazer a normalização desse código genético não foram capazes de corrigir os defeitos encontrados.");
		    }

		}
		paramDisp.removeAll(param);
	    }
	    if (!codGen.get(indexMor).getMetaInfo().getReturnTp().getClass().equals(Void.class))
		paramDisp.add(0, codGen.get(indexMor));
	    paramDisp.addAll(tempFora);
	    tempFora.clear();
	}

	tempFora.clear();
	for (int i = 0; i < paramDisp.size(); i++) {
	   if (paramDisp.get(i).getMetaInfo().getReturnTp().equals(Tipo.TP_VOID))
	       tempFora.add(paramDisp.get(i));	   
	}
	paramDisp.removeAll(tempFora);
	if (paramDisp.size()>1){
	    for (SubAlgoritmo<?> sa : genUtilizavel) {
		if (tentarPreparar(sa, paramDisp)){
		    codGen.add(codGen.indexOf(paramDisp.get(0)),sa);
		    break;
		}		    
	    }
	}
	return codGen;
    }

}
