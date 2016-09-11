package br.com.matrix.evo;

import br.com.matrix.evo.suporte.CodigoGenEvo;
import br.com.matrix.evo.suporte.FitnessEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;

/**
 * Interface de entidade evolutiva.
 * 
 *
 * @param <G>
 *            - Tipagem do codigo genético
 * @param <R>
 *            - Tipagem do retorno das entidades
 * @param <P>
 *            - Parametro de execucao
 * 
 */
public interface EntidadeEvo<G, R, P> extends Comparable<EntidadeEvo<G, R, P>> {

    public CodigoGenEvo<G> getCG();

    /**
     * 
     * @return Fitness, um valor quantitativo da adaptação ao ambiente.
     */
    public FitnessEvo getFitness();

    /**
     * 
     * @param p
     *            - Parametro para execucao.
     * @return retorno
     */
    public R executar(P p);

    /**
     * 
     * @param lG
     *            - Lista de genitores, grupo usado para gerar novos indivíduos.
     * @param qt
     *            - Qauntidade de novos indiviuos
     * 
     * @return Novas entidades.
     */
    public GrupoEntidadesEvo<G, R, P> reproduzir(GrupoEntidadesEvo<G, R, P> lG, int qt);

    /**
     * Altera um dos valores dentro do código genético.
     */
    public void mutar();

    /**
     * Trata o Cógido genético, para evitar erros.
     */
    public void padronizaCG();

    @Override
    public default int compareTo(EntidadeEvo<G, R, P> o) {
	return getFitness().compareTo(o.getFitness());
    }
}