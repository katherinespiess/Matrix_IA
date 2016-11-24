package br.com.matrix.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import br.com.matrix.aplicacao.ParametroEntrada;
import br.com.matrix.banco.Database;
import br.com.matrix.banco.tabelas.interfaces.ILinha;
import br.com.matrix.evo.EntidadeEvo;
import br.com.matrix.evo.GerenciadorEvo;
import br.com.matrix.evo.suporte.CondicaoFimEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;

public final class GerenciadorMatrix
		implements GerenciadorEvo<EstruturaMatrix, SugestaoMatrix, ParametroEntrada, HashMap<String, Object>> {

	private static GerenciadorMatrix m;
	
	public final static Random r = new Random();
	private GrupoEntidadesEvo<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> lE;

	public GerenciadorMatrix() {
		Iterable<ILinha> l = Database.execute("select id from sugestores where ie_ativo");
		for (ILinha li : l) {
			getLE().add(new Sugestor(Integer.valueOf(li.getCampos().get(0).getValor().toString()), this));
		}
	}

	@Override
	public GrupoEntidadesEvo<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> getLE() {
		if (lE == null)
			lE = new GrupoEntidadesEvo<EstruturaMatrix, SugestaoMatrix, ParametroEntrada>();
		return lE;
	}

	@Override
	public void rodarLE(CondicaoFimEvo<HashMap<String, Object>> cF) {
		
	}

	public List<SugestaoMatrix> getLSugest(ParametroEntrada p) {
		List<SugestaoMatrix> result = new ArrayList<>();

		for (EntidadeEvo<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> ent : getLE()) {
			SugestaoMatrix temp = ent.executar(p);
			if (temp != null)
				result.add(temp);
		}

		return result;
	}

	public static GerenciadorMatrix getInstance() {
		if (m == null)
			m = new GerenciadorMatrix();
		return m;
	}

}
