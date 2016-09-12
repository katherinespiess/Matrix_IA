package br.com.matrix.subAlgoritmo.MetaInfo;

public interface MetaInfoAssinatura extends MetaInfo {
    public Quantidade getQt();

    public static boolean equals(MetaInfoAssinatura m1, MetaInfoAssinatura m2) {

	if (!MetaInfo.tpEquals(m1, m2))
	    return false;

	return m1.getQt().getMax() == m2.getQt().getMax() && m1.getQt().getMin() == m2.getQt().getMin();

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
