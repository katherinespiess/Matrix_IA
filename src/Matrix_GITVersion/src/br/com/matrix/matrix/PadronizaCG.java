package br.com.matrix.matrix;

import br.com.matrix.evo.suporte.CodigoGenEvo;
import br.com.matrix.evo.suporte.PadronizarCodigoGenetico;

/**
 * Regra de padronização do código genético
 * 
 * @author GustavoHenrique
 *
 */
public class PadronizaCG implements PadronizarCodigoGenetico<EstruturaMatrix> {

	@Override
	public CodigoGenEvo<EstruturaMatrix> apply(CodigoGenEvo<EstruturaMatrix> t) {
		CodigoGenEvo<EstruturaMatrix> cG = t;
		for (int i = 0; i < cG.size() - 1; i++) {
			for (int j = 0; j < cG.size(); j++) {
				if (cG.get(i).equals(cG.get(j))) {
					cG.remove(j);
				}
			}
		}
		return cG;
	}

}
