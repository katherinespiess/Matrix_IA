package br.com.matrix.evo.suporte;

import java.util.function.BiFunction;

/**
 * Interface de execucao para entidadePadrao.
 * 
 * @author GustavoHenrique
 *
 * @paramReq <G>
 *            - Tipagem do codigo genético
 * @paramReq <R>
 *            - Tipagem do retorno das entidades
 * @paramReq <P>
 *            - Parametro de execucao
 */
public interface Executar<G, P, R> extends BiFunction<CodigoGenEvo<G>, P, R> {

}
