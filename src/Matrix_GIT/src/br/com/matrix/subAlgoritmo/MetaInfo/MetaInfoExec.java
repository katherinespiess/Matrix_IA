package br.com.matrix.subAlgoritmo.MetaInfo;

import java.util.List;

public interface MetaInfoExec extends MetaInfo {
    public List<MetaInfoAssinatura> getParam();

    /**
     * 
     * @param m1 MetaInfoExec 1
     * @param m2 MetaInfoExec 2
     * @return true se a tipageme os parâmetros requeridos são os mesmos
     */
    public static boolean equals(MetaInfoExec m1, MetaInfoExec m2) {
	if (!MetaInfo.tpEquals(m1, m2))
	    return false;

	if (m1.getParam().size() != m2.getParam().size())
	    return false;

	m1.getParam().sort(tpComparator);
	m2.getParam().sort(tpComparator);
	
	for (int i = 0; i < m1.getParam().size(); i++) {
	    if (!m1.getParam().get(i).equals(m2.getParam().get(2)))
		return false;
	}

	return true;
    }

    /**
     * 
     * @param t
     *            Tipagem do retorno do subAlgoritmo referete.
     * @param l
     *            Parâmetros para a preparação do subAlgoritmo.
     * @return - Uma nova instância de MetaInfoExec com as características
     *         passadas por parâmetro.
     */
    public static MetaInfoExec fabricar(Tipo t, List<MetaInfoAssinatura> l) {
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
