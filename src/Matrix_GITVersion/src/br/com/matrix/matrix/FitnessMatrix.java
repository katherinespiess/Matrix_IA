package br.com.matrix.matrix;

import br.com.matrix.aplicacao.ParametroEntrada;
import br.com.matrix.evo.padrao.EntidadePadrao;
import br.com.matrix.evo.padrao.FitnessPadrao;
import br.com.matrix.evo.padrao.GerarFitness;
import br.com.matrix.evo.suporte.FitnessEvo;

/**
 * Fitness para as entidades matrix.
 * 
 * @author GustavoHenrique
 *
 */
public class FitnessMatrix implements
		GerarFitness<EntidadePadrao<EstruturaMatrix, SugestaoMatrix, ParametroEntrada>, EstruturaMatrix, SugestaoMatrix, ParametroEntrada> {

	@Override
	public FitnessEvo apply(EntidadePadrao<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> p) {
		Sugestor t = (Sugestor) p;
		Double d = Double.valueOf((t.getQtAcerto() * 100) / t.getQtUso());
		return new FitnessPadrao(d);
	}
}
