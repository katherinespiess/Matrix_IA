package br.com.matrix.evo.padrao;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.evo.suporte.CondicaoAgrupamentoEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;

public class CondicaoAgrupamentoPadrao {


    /**
     * Condicao de agrupamento por pares. Os dois primeiros, os dois
     * seguintes, e assim ate os ultimos. Se a quantidade de individuos
     * for impar, unira o ultimo com o primeiro.
     *
     * @paramReq <G>
     *            - Tipagem do codigo genético
     * @paramReq <R>
     *            - Tipagem do retorno das entidades
     * @paramReq <P>
     *            - Parametro de execucao
     */
    public static <G, R, P> CondicaoAgrupamentoEvo<G, R, P> getCondicaoAgrupamentoPar() {
	return new CondicaoAgrupamentoEvo<G, R, P>() {
	    @Override
	    public List<GrupoEntidadesEvo<G, R, P>> apply(GrupoEntidadesEvo<G, R, P> t) {
		ArrayList<GrupoEntidadesEvo<G, R, P>> r = new ArrayList<GrupoEntidadesEvo<G, R, P>>();
		GrupoEntidadesEvo<G, R, P> g;

		for (int i = 0; i < t.size(); i += 2) {
		    g = new GrupoEntidadesEvo<G, R, P>();
		    g.add(t.get(i));
		    g.add(t.get((i + 1) % t.size()));
		    r.add(g);
		}

		return r;
	    }
	};

    }

    /**
     * Condicao de agrupamento por trios. Sendo os grupos [1, 2, 3], [3, 4, 5],
     * [5, 6, 7] Se a quantidade de individuos nao for multiplo de tres, unira o
     * ultimo com o primeiro.
     * 
     * 
     *
     * @paramReq <G>
     *            - Tipagem do código genético
     * @paramReq <R>
     *            - Tipagem do retorno das entidades
     */
    public static <G, R, P> CondicaoAgrupamentoEvo<G, R, P> getCondicaoAgrupamentoTrio() {

	return new CondicaoAgrupamentoEvo<G, R, P>() {
	    @Override
	    public List<GrupoEntidadesEvo<G, R, P>> apply(GrupoEntidadesEvo<G, R, P> t) {
		ArrayList<GrupoEntidadesEvo<G, R, P>> r = new ArrayList<GrupoEntidadesEvo<G, R, P>>();
		GrupoEntidadesEvo<G, R, P> g;

		for (int i = 0; i < t.size(); i += 2) {
		    g = new GrupoEntidadesEvo<G, R, P>();
		    g.add(t.get(i));
		    g.add(t.get((i + 1) % t.size()));
		    g.add(t.get((i + 2) % t.size()));
		    r.add(g);
		}

		return r;
	    }
	};
    }
    
    /**
    
    /**
     * Condicao de agrupamento por de lider. Adiciona o mais apto para todos os grupos retornados por a
     * 
     *
     * @paramReq <G>
     *            - Tipagem do código genético
     * @paramReq <R>
     *            - Tipagem do retorno das entidades
     *
     * @param a - Condição de agrupamento sobre a qual essa se aplica
     */
    public static <G, R, P> CondicaoAgrupamentoEvo<G, R, P> getCondicaoAgrupamentoLider(CondicaoAgrupamentoEvo<G, R, P> a) {

	return new  CondicaoAgrupamentoEvo<G, R, P>(){
	    @Override
	    public List<GrupoEntidadesEvo<G, R, P>> apply(GrupoEntidadesEvo<G, R, P> t) {
		t.sort();
		ArrayList<GrupoEntidadesEvo<G, R, P>> r = new ArrayList<GrupoEntidadesEvo<G, R, P>>();		
		r.addAll(a.apply(t));

		for (GrupoEntidadesEvo<G, R, P> g : r) {
		    g.add(t.getFirst());
		}

		return r;
	    }
	};
    }
}
