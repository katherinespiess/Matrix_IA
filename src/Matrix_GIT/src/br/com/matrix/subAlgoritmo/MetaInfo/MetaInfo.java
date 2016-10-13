package br.com.matrix.subAlgoritmo.MetaInfo;

import java.util.Comparator;
import java.util.List;

/**
 * Interface pai para MetaInfo
 * 
 * @author GustavoHenrique
 *
 */
public interface MetaInfo {

    /**
     * 
     * @return A tipagem do retorno do subAlgoritmo ao qual essa instância de
     *         MetaInfo se refere.
     */
    public Tipo getReturnTp();

    /**
     * Verifica se a tipagem é a mesma, se são instancias de MetaInfoAssinatura
     * ou de MetaInfoExec
     * 
     * @param m1
     *            - primeiro MetaInfo
     * @param m2
     *            - segundo MetaInfo
     * @return true se a tipagem for a mesma e forem ambos ou Assinatura ou
     *         execução, nesse segundo caso é feita a verificação nas classes
     *         respectivas também.
     */
    public static boolean equals(MetaInfo m1, MetaInfo m2) {

	if (!tpEquals(m1, m2))
	    return false;

	if ((m1 instanceof MetaInfoAssinatura) && (m2 instanceof MetaInfoAssinatura))
	    return MetaInfoAssinatura.equals((MetaInfoAssinatura) m1, (MetaInfoAssinatura) m2);

	if ((m1 instanceof MetaInfoExec) && (m2 instanceof MetaInfoExec))
	    return MetaInfoExec.equals((MetaInfoExec) m1, (MetaInfoExec) m2);

	return true;
    }

    /**
     * 
     * @param m1
     *            - primeiro MetaInfo
     * @param m2
     *            - segundo MetaInfo
     * @return true se a tipagem for equivalente.
     */
    public static boolean tpEquals(MetaInfo m1, MetaInfo m2) {
	return m1.getReturnTp().equals(m2.getReturnTp());
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
    public static MetaInfoAssinatura fabricarAssinatura(Tipo t, Quantidade quantidade) {
	return MetaInfoAssinatura.fabricar(t, quantidade);
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
    public static MetaInfoExec fabricarExec(Tipo t, List<MetaInfoAssinatura> l) {
	return MetaInfoExec.fabricar(t, l);
    }

    /**
     * Comparator que utiliza a classificação do tipo de retorno.
     */
    public static final Comparator<MetaInfo> tpComparator = new Comparator<MetaInfo>() {

	@Override
	public int compare(MetaInfo o1, MetaInfo o2) {
	    int r = o1.getReturnTp().getSimpleName().compareTo(o2.getReturnTp().getSimpleName());
	    return r;
	}
    };
}
