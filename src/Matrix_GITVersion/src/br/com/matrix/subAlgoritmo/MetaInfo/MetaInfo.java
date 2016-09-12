package br.com.matrix.subAlgoritmo.MetaInfo;

import java.util.List;

public interface MetaInfo {
    public Tipo getReturnTp();

    public static boolean equals(MetaInfo m1, MetaInfo m2){

	if (!tpEquals(m1, m2))
	    return false;
	
	if ((m1 instanceof MetaInfoAssinatura) && (m2 instanceof MetaInfoAssinatura))	    
	    return MetaInfoAssinatura.equals((MetaInfoAssinatura) m1, (MetaInfoAssinatura) m2);

	 if((m1 instanceof MetaInfoExec) && (m2 instanceof MetaInfoExec))
	    return MetaInfoExec.equals((MetaInfoExec) m1, (MetaInfoExec) m2);

	return true;
    }
    
    public static boolean tpEquals(MetaInfo m1, MetaInfo m2){
	return m1.getReturnTp().equals(m2.getReturnTp());
    }
    
    public static MetaInfoAssinatura fabricarAssinatura(Tipo t, Quantidade quantidade){
	return MetaInfoAssinatura.fabricarAssinatura(t, quantidade);
    }
    
    public static MetaInfoExec fabricarExec(Tipo t, List<MetaInfoAssinatura> l){
	return MetaInfoExec.fabricarExec(t, l);
    }
}
