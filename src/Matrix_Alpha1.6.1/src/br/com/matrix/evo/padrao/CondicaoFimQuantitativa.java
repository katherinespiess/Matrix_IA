package br.com.matrix.evo.padrao;

import br.com.matrix.evo.suporte.CondicaoFimEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;

/**
 * Condicao Fim quantitativa. Com capacidade de considerar as geracoes
 * decorridas, e as geracoes com o mesmo valor Fitness.
 * 
 *
 * @param <G>
 *            - Tipagem do código genético
 * @param <R>
 *            - Tipagem do retorno das entidades
 */
public class CondicaoFimQuantitativa<G, R, P> implements CondicaoFimEvo<GrupoEntidadesEvo<G, R, P>> {

    private Integer qtGeracaoLimite;
    private Integer qtGeracaoFELimite;

    /**
     * Valores nulos ou zero serao desconsiderados. Se ambos forem nulos ou
     * zero, serao considerados como 100
     * 
     * @param qtGeracaoLimite
     *            - Quantidade de geracoes para serem consideradas antes de sair
     *            da repeticao;
     * @param qtGeracaoFELimite
     *            - Quantidade de geracoes com o mesmo fitness a serem
     *            consideradas antes de sair da repeticao;
     */
    public CondicaoFimQuantitativa(Integer qtGeracaoLimite, Integer qtGeracaoFELimite) {
	this.qtGeracaoFELimite = qtGeracaoFELimite != null ? qtGeracaoFELimite : 0;
	this.qtGeracaoLimite = qtGeracaoLimite != null ? qtGeracaoLimite : 0;
	if (this.qtGeracaoFELimite.equals(0) && this.qtGeracaoLimite.equals(0)) {
	    this.qtGeracaoLimite = 100;
	    this.qtGeracaoFELimite = 100;
	}
    }

    @Override
    /**
     * 
     * @param arg0
     * @return verdadeiro enquanto nenhum dos limites tiver sido atingido.
     */
    public boolean test(GrupoEntidadesEvo<G, R, P> arg0) {

	if (arg0.getQtGeracao() == 0 || arg0.getFirst().getFitness().compareTo(arg0.getfE()) < 0) {
	    arg0.echo();
	    arg0.setFE(arg0.getFirst().getFitness());
	}

	arg0.incQtGeracao();
	arg0.incQtGeracaoFE();

	boolean r = false;

	r = (arg0.getQtGeracaoFE() < qtGeracaoFELimite || 0 == qtGeracaoFELimite)
		&& (arg0.getQtGeracao() < qtGeracaoLimite || 0 == qtGeracaoLimite);

	if (!r) {
	    arg0.echo();
	}

	return r;
    }

}
