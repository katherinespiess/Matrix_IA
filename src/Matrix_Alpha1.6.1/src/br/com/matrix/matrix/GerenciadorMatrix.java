package br.com.matrix.matrix;

import java.util.HashMap;
import java.util.Random;

import br.com.matrix.evo.GerenciadorEvo;
import br.com.matrix.evo.suporte.CondicaoFimEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;

public final class GerenciadorMatrix
		implements GerenciadorEvo<EstruturaMatrix, String, String, HashMap<String, Object>> {

	public final static Random r = new Random();
	private GrupoEntidadesEvo<EstruturaMatrix, String, String> lE;

	@Override
	public GrupoEntidadesEvo<EstruturaMatrix, String, String> getLE() {
		if (lE == null)
			lE = new GrupoEntidadesEvo<EstruturaMatrix, String, String>();
		return lE;
	}

	@Override
	public void rodarLE(CondicaoFimEvo<HashMap<String, Object>> cF) {
		// TODO Auto-generated method stub

	}

}
