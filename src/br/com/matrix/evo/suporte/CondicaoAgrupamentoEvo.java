/**
 * 
 */
package br.com.matrix.evo.suporte;

import java.util.List;
import java.util.function.Function;

/**
 * Condicao usada para agrupar entidades para gerarem novas entidades.
 * 
 * @param <G>
 *            - Tipagem do código genético
 * @param <R>
 *            - Tipagem do retorno das entidades
 *
 */
public abstract interface CondicaoAgrupamentoEvo<G, R, P>
		extends Function<GrupoEntidadesEvo<G, R, P>, List<GrupoEntidadesEvo<G, R, P>>> {

}
