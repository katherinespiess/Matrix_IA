/**
 * 
 */
package br.com.matrix.evo;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.evo.suporte.CondicaoAgrupamentoEvo;
import br.com.matrix.evo.suporte.CondicaoFimEvo;
import br.com.matrix.evo.suporte.CondicaoRemocaoEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;

/**
 * Interface que gerencia um grupo de entidades evo, executando Crosover,
 * mutacao, etc...S
 * 
 *
 * @paramReq <G>
 *            - Tipagem do código genético
 * @paramReq <R>
 *            - Tipagem do retorno das entidades
 * @paramReq <F>
 *            - Tipagem da entrada da condição fim para rodar as entidades
 * @paramReq <P>
 *            - Parametro de execucao
 */
public interface GerenciadorEvo<G, R, P, F> {
    /**
     * 
     * @paramReq cF
     *            - Condição fim, usado para determinar até quando continuará.
     */
    public void rodarLE(CondicaoFimEvo<F> cF);

    /**
     * 
     * @paramReq cA
     *            - Condição de agrupamento, usada para determinar os grupos de
     *            genitores.
     * 
     * @paramReq qtGrupo
     *            - quantidade de novos indivividuos por grupo reprodutorio;
     */
    public default void reproduzirLE(CondicaoAgrupamentoEvo<G, R, P> cA, int qtGrupo) {
	List<GrupoEntidadesEvo<G, R, P>> lG = cA.apply(getLE());
	for (GrupoEntidadesEvo<G, R, P> g : lG) {
	    getLE().addAll(g.get(0).reproduzir(g, qtGrupo));
	}
    }

    /**
     * 
     * @paramReq cR
     *            - Condição de remoção, usada para determinar as entidades à
     *            serem removidas.
     */
    public default void removerLE(CondicaoRemocaoEvo<G, R, P> cR) {
	ArrayList<EntidadeEvo<G, R, P>> grupo = cR.apply(getLE());
	getLE().removeAll(grupo);
    }

    /**
     * Constroi a lista de entidades se estiver nula
     * 
     * @return lista de entidades.
     */
    GrupoEntidadesEvo<G, R, P> getLE();
}
