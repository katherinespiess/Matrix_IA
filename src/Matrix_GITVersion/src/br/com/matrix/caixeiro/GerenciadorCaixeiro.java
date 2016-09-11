package br.com.matrix.caixeiro;

import java.util.Random;

import br.com.matrix.evo.GerenciadorEvo;
import br.com.matrix.evo.padrao.CondicaoAgrupamentoPadrao;
import br.com.matrix.evo.padrao.CondicaoFimQuantitativa;
import br.com.matrix.evo.padrao.CondicaoRemocaoFracao;
import br.com.matrix.evo.suporte.CondicaoFimEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;

public class GerenciadorCaixeiro
		implements GerenciadorEvo<Coordenada, Double, Void, GrupoEntidadesEvo<Coordenada, Double, Void>> {

	private GrupoEntidadesEvo<Coordenada, Double, Void> lE;

	static final Random r = new Random();

	public GerenciadorCaixeiro() {
		for (int i = 0; i < 16; i++) {
			getLE().add(new EntidadeCaixeiro());
		}
	}

	@Override
	public void rodarLE(CondicaoFimEvo<GrupoEntidadesEvo<Coordenada, Double, Void>> cF) {
		while (cF.test(getLE())) {
			this.removerLE(new CondicaoRemocaoFracao<>(2d));
			getLE().sort();
			for (int i = 0; i < getLE().size(); i++) {
				while (i > 0 && (r.nextBoolean() || r.nextBoolean()))
					getLE().get(i).mutar();
			}
			this.reproduzirLE(CondicaoAgrupamentoPadrao.getCondicaoAgrupamentoLider(
					CondicaoAgrupamentoPadrao.getCondicaoAgrupamentoTrio()), lE.size() < 32 ? 5 : 1);
		}

	}

	@Override
	public GrupoEntidadesEvo<Coordenada, Double, Void> getLE() {
		if (lE == null)
			lE = new GrupoEntidadesEvo<Coordenada, Double, Void>();
		return lE;
	}

	/**
	 * Execucuta.
	 */
	public static void run() {
		new GerenciadorCaixeiro().rodarLE(new CondicaoFimQuantitativa<>(6500, (Coordenada.getMap().size() * 100)));
	}
}
