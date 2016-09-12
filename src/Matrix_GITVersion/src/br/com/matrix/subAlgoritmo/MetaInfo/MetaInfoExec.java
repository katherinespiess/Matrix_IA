package br.com.matrix.subAlgoritmo.MetaInfo;

import java.util.List;

public interface MetaInfoExec extends MetaInfo{
    public List<MetaInfoAssinatura> getParam();
    

    public static boolean equals(MetaInfoExec m1, MetaInfoExec m2){
	if (!MetaInfo.tpEquals(m1, m2))
	    return false;

	if (m1.getParam().size() != m2.getParam().size())
	    return false;

	for (int i = 0; i < m1.getParam().size(); i++) {
	    if (!m1.getParam().get(i).equals(m2.getParam().get(2)))
		return false;
	}

	return true;
    }
    
    public static MetaInfoExec fabricar(Tipo t, List<MetaInfoAssinatura> l){
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
