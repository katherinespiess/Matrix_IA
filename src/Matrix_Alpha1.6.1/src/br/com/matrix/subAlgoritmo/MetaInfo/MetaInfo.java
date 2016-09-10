package br.com.matrix.subAlgoritmo.MetaInfo;

import java.util.List;

public interface MetaInfo {
    public Tipo getReturnTp();
    
    public default boolean equals(MetaInfo m1, MetaInfo m2){
	
	if (!m1.getReturnTp().get().equals(m2.getReturnTp().get()))
	    return false;
		    
	
	if ((m1 instanceof MetaInfoAssinatura) && (m2 instanceof MetaInfoAssinatura)) {
	    MetaInfoAssinatura ma1 = (MetaInfoAssinatura) m1;
	    MetaInfoAssinatura ma2 = (MetaInfoAssinatura) m2;
	    
	    return ma1.getQt().getMax() == ma2.getQt().getMax() && ma1.getQt().getMin() == ma2.getQt().getMin();
	}
	
	return true;
    }
    
    public static MetaInfoAssinatura fabricarAssinatura(Tipo t, Qt qt){
	return new MetaInfoAssinatura() {
	    
	    @Override
	    public Tipo getReturnTp() {
		return t;
	    }
	    
	    @Override
	    public Qt getQt() {
		return qt;
	    }
	};
    }
    
    public static MetaInfoExec fabricarExec(Tipo t, List<MetaInfoAssinatura> l){
	return new MetaInfoExec() {
	    
	    @Override
	    public Tipo getReturnTp() {
		return t;
	    }
	    
	    @Override
	    public List<MetaInfoAssinatura> getParam() {
		return l;
	    }
	};
    }
}
