package br.com.matrix.evo.suporte;

import java.util.function.BiFunction;

/**
 * Interface de execucao para entidadePadrao.
 * 
 * @author GustavoHenrique
 *
 * @param <G>
 *            - Tipagem do codigo genético
 * @param <R>
 *            - Tipagem do retorno das entidades
 * @param <P>
 *            - Parametro de execucao
 */
public interface Executar<G, P, R> extends BiFunction<CodigoGenEvo<G>, P, R> {

}
