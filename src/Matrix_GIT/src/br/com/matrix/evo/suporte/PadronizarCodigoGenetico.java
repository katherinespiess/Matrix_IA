package br.com.matrix.evo.suporte;

import java.util.function.Function;

/**
 * Interface de padronizacao de código genético para EntidadePadrao
 * 
 * @paramReq <G>
 *            - Tipagem do código genético
 */
public interface PadronizarCodigoGenetico<G> extends Function<CodigoGenEvo<G>, CodigoGenEvo<G>> {

}
