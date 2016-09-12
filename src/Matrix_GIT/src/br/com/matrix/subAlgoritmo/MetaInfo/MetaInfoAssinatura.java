package br.com.matrix.subAlgoritmo.MetaInfo;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.SubAlgoritmo;

public interface MetaInfoAssinatura extends MetaInfo {
    public Quantidade getQt();

    public static boolean equals(MetaInfoAssinatura m1, MetaInfoAssinatura m2) {

	if (!MetaInfo.tpEquals(m1, m2))
	    return false;

	return m1.getQt().getMax() == m2.getQt().getMax() && m1.getQt().getMin() == m2.getQt().getMin();

    }
    
    public static boolean compararListaMetaInfoSubAlg(List<MetaInfoAssinatura> lmia, List<SubAlgoritmo<?>> lsa){
	List<MetaInfoExec> lmie = new ArrayList<>(lsa.size());
	for (SubAlgoritmo<?> sa : lsa) {
	    lmie.add(sa.getMetaInfo());
	}
	return compararListaMetaInfo(lmia, lmie);
    }
    
    public static boolean compararListaMetaInfo(List<MetaInfoAssinatura> lmia, List<MetaInfoExec> lmie){
	
	lmia.sort(MetaInfo.tpComparator);
	lmie.sort(MetaInfo.tpComparator);
	
	StringBuilder assinatura = new StringBuilder();
	for (MetaInfoAssinatura a : lmia) {
	    assinatura.append("("+a.getReturnTp().getSimpleName()+"){"+a.getQt().getMin()+","+a.getQt().getMax()+"}");
	}
	
	StringBuilder exec = new StringBuilder();
	for (MetaInfoExec metaInfoExec : lmie) {
	    exec.append(metaInfoExec.getReturnTp().getSimpleName());
	}

	return exec.toString().matches(assinatura.toString());
    }

    public static MetaInfoAssinatura fabricar(Tipo t, Quantidade quantidade) {
	return new MetaInfoAssinatura() {

	    @Override
	    public Tipo getReturnTp() {
		return t;
	    }

	    @Override
	    public Quantidade getQt() {
		return quantidade;
	    }
	};
    }
}
