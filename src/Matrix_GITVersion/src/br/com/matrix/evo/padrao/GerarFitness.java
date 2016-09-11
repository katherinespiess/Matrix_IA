package br.com.matrix.evo.padrao;

import java.util.function.Function;

import br.com.matrix.evo.suporte.FitnessEvo;

/**
 * Interface de cálculo do fitness para entidade padrao.
 * 
 * @author GustavoHenrique
 *
 * @param <E>
 *            - Tipagem da entidadede de que se gera o fitness
 * @param <G>
 *            - Tipagem do codigo genético
 * @param <R>
 *            - Tipagem do retorno das entidades
 * @param <P>
 *            - Parametro de execucao
 */
public interface GerarFitness<E extends EntidadePadrao<G, R, P>, G, R, P> extends Function<E, FitnessEvo> {

}
