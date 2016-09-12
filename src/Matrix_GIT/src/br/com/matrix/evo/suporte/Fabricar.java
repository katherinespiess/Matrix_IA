package br.com.matrix.evo.suporte;

import java.util.function.Supplier;

import br.com.matrix.evo.EntidadeEvo;

/**
 * Interface supplier de entidades padrao para a reproducao da mesma.
 * 
 * @paramReq <G>
 *            - Tipagem do código genético
 * @paramReq <R>
 *            - Tipagem do retorno das entidades
 * @paramReq <P>
 *            - Parametro de execucao
 */
public interface Fabricar<G, R, P> extends Supplier<EntidadeEvo<G, R, P>> {

}
