package br.com.matrix.evo.padrao;

import br.com.matrix.evo.suporte.CondicaoRemocaoEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;

/**
 * Remocao por fracao, serao retornadas 1/d das entidades. Onde d é um número
 * delimitado na criacao do objeto.
 * 
 * 
 * @paramReq <G>
 *            - Tipagem do código genético
 * @paramReq <R>
 *            - Tipagem do retorno das entidades
 */
public class CondicaoRemocaoFracao<G, R, P> implements CondicaoRemocaoEvo<G, R, P> {

	private Double d;

	/**
	 * 
	 * @paramReq d
	 *            - Divisor de remocao, dois para 50%, três para 33.3%, etc.
	 */
	public CondicaoRemocaoFracao(Double d) {
		this.d = d;
	}

	@Override
	public GrupoEntidadesEvo<G, R, P> apply(GrupoEntidadesEvo<G, R, P> t) {
		t.sort();
		GrupoEntidadesEvo<G, R, P> r = new GrupoEntidadesEvo<G, R, P>();
		r.addAll(t.subList((new Double(t.size() / d)).intValue(), t.size()));
		return r;
	}

}
