package br.com.matrix.evo.padrao;

import br.com.matrix.evo.suporte.FitnessEvo;

/**
 * Fitness Padronizado.
 *
 */
public class FitnessPadrao implements FitnessEvo {

	Double d;

	/**
	 * Fitness bruto, sem tratamentos.
	 * 
	 * @paramReq d
	 *            - Valor bruto do fitnes.
	 */
	public FitnessPadrao(Double d) {
		this.d = d;
	}

	/**
	 * Fitness recebe a diferença em modulo do objetivo e do valor bruto.
	 * 
	 * @paramReq d
	 *            - Valor bruto do fitness
	 * @paramReq o
	 *            - Valor objetivo
	 */
	public FitnessPadrao(Double d, Double o) {
		Double a = o - d;

		if (a < 0) {
			a *= -1;
		}

		this.d = -1*a;
	}

	@Override
	public Double get() {
		return d;
	}

}
