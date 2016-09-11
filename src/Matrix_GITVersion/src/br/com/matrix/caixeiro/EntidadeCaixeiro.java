package br.com.matrix.caixeiro;

import br.com.matrix.evo.EntidadeEvo;
import br.com.matrix.evo.padrao.EntidadePadrao;
import br.com.matrix.evo.padrao.FitnessPadrao;
import br.com.matrix.evo.suporte.CodigoGenEvo;
import br.com.matrix.evo.suporte.Fabricar;
import br.com.matrix.evo.suporte.FitnessEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;

public class EntidadeCaixeiro implements EntidadeEvo<Coordenada, Double, Void> {

	CodigoGenEvo<Coordenada> cG;

	public EntidadeCaixeiro() {
		getCG().addAll(Coordenada.getMap());
		for (int i = 0; i < 36; i++) {
			mutar();
		}
	}

	public EntidadeCaixeiro(CodigoGenEvo<Coordenada> cG) {

		for (int j = 0; j < cG.size(); j++) {
			Coordenada cj = cG.get(j);
			getCG().add(j, cj);
		}
	}

	@Override
	public int compareTo(EntidadeEvo<Coordenada, Double, Void> arg0) {
		return getFitness().compareTo(arg0.getFitness());
	}

	@Override
	public CodigoGenEvo<Coordenada> getCG() {
		if (cG == null)
			cG = new CodigoGenEvo<Coordenada>();
		return cG;
	}

	@Override
	public FitnessEvo getFitness() {
		return new FitnessPadrao(executar(null).doubleValue() * -1 + 500);
	}

	@Override
	public Double executar(Void v) {
		Double r = 0d;
		for (int i = 0; i < getCG().size(); i++) {
			r += getCG().get(i).getDist(getCG().get((i + 1) % getCG().size()));
		}
		return r;
	}

	@Override
	public GrupoEntidadesEvo<Coordenada, Double, Void> reproduzir(GrupoEntidadesEvo<Coordenada, Double, Void> lG,
			int qt) {
		return EntidadePadrao.getRepPadrao(new Fabricar<Coordenada, Double, Void>() {
			@Override
			public EntidadeCaixeiro get() {
				return new EntidadeCaixeiro();
			}
		}).apply(lG, qt);
	}

	@Override
	public void mutar() {
		if (GerenciadorCaixeiro.r.nextBoolean())
			cG = EntidadePadrao.<Coordenada> getMutPadraoTrocaComplexa().apply(getCG());
		if (GerenciadorCaixeiro.r.nextBoolean())
			cG = EntidadePadrao.<Coordenada> getMutPadraoTrocaAnexo().apply(getCG());
	}

	@Override
	public void padronizaCG() {
		if (getCG().containsAll(Coordenada.getMap()))
			return;

		CodigoGenEvo<Coordenada> c = Coordenada.getMap();
		c.removeAll(getCG());

		for (int i = 0; i < getCG().size() - 1; i++) {
			for (int j = i + 1; j < getCG().size(); j++) {
				if (getCG().get(i).equals(getCG().get(j))) {
					getCG().set(j, c.get(0));
					c.remove(0);
				}
			}
		}

	}
}
