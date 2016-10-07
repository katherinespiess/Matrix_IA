package br.com.matrix.subAlgoritmo.MetaInfo;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.SubAlgoritmo;

/**
 * Assinatura das MetaInfos dos SubAlgoritmos requeridos como parâmetros por um
 * terceiro.
 * 
 * @author GustavoHenrique
 *
 */
public interface MetaInfoAssinatura extends MetaInfo {

    /**
     * 
     * @return A quantidade de SubAlgoritmos para esse tipo de retorno que se
     *         espera.
     */
    public Quantidade getQt();

    /**
     * 
     * @param m1
     *            MetaInfoAssinatura 1
     * @param m2
     *            MetaInfoAssinatura 2
     * @return true se atipagem for a mesma e a quantia tiver os mesmos valores.
     */
    public static boolean equals(MetaInfoAssinatura m1, MetaInfoAssinatura m2) {

	if (!MetaInfo.tpEquals(m1, m2))
	    return false;

	return m1.getQt().getMax() == m2.getQt().getMax() && m1.getQt().getMin() == m2.getQt().getMin();

    }

    /**
     * 
     * @param lmia
     *            Lisra de MetaInfoAssinatura
     * @param lsa
     *            Lista de SubAlgoritmos
     * @return true se há subAlgorimos de cada tipo suficientes superar o minimo
     *         sem extrapolar o maximos das MetaInfos.
     */
    public static boolean compararListaMetaInfoSubAlg(List<MetaInfoAssinatura> lmia, List<SubAlgoritmo<?>> lsa) {
	List<MetaInfoExec> lmie = new ArrayList<>(lsa.size());
	for (SubAlgoritmo<?> sa : lsa) {
	    lmie.add(sa.getMetaInfo());
	}
	return compararListaMetaInfo(lmia, lmie);
    }

    /**
     * 
     * @param lmia
     *            Lisra de MetaInfoAssinatura
     * @param lmie
     *            Lista de MetaInfoExec
     * @return true se há uma quantia de MetaInfoExec de cada tipo suficiente superar o minimo
     *         sem extrapolar o maximos de cada MetaInfoAssinatura.
     */
    public static boolean compararListaMetaInfo(List<MetaInfoAssinatura> lmia, List<MetaInfoExec> lmie) {

	if (lmie == null || lmia == null)
	    return false;
	
	lmia.sort(MetaInfo.tpComparator);
	lmie.sort(MetaInfo.tpComparator);

	StringBuilder assinatura = new StringBuilder();
	for (MetaInfoAssinatura a : lmia) {
	    assinatura.append(
		    "(" + a.getReturnTp().getSimpleName() + "){" + a.getQt().getMin() + "," + a.getQt().getMax() + "}");
	}

	StringBuilder exec = new StringBuilder();
	for (MetaInfoExec metaInfoExec : lmie) {
	    exec.append(metaInfoExec.getReturnTp().getSimpleName());
	}

	return exec.toString().matches(assinatura.toString());
    }

    /**
     * 
     * 
     * @param t
     *            tipagem do retorno requerido.
     * @param quantidade
     *            - quantidade requerida.
     * @return uma nova instância de MetaInfoAssinatura com as características
     *         passadas por parâmetro.
     */
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
