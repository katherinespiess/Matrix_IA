package br.com.matrix.matrix;

import java.util.List;

import br.com.matrix.evo.EntidadeEvo;
import br.com.matrix.evo.padrao.EntidadePadrao;
import br.com.matrix.evo.suporte.CodigoGenEvo;
import br.com.matrix.evo.suporte.Executar;
import br.com.matrix.evo.suporte.Fabricar;
import br.com.matrix.aplicacao.ParametroEntrada;
import br.com.matrix.banco.Database;

/**
 * 
 * Entidade matrix, retorna uma String.
 * 
 */
public class Sugestor extends EntidadePadrao<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> {

	private Integer qtUso;
	private Integer qtAcerto;

	public Sugestor(List<EstruturaMatrix> pG, int qtGenes) {
		super(getExeMatrix(), EntidadePadrao.getMutPadraoTrocaComplexa(),
				EntidadePadrao.getRepOrdenada(getNewSugestor()), new FitnessMatrix(), new PadronizaCG(), pG, qtGenes);
	}

	public Sugestor() {
		super(getExeMatrix(), EntidadePadrao.getMutPadraoTrocaComplexa(),
				EntidadePadrao.getRepOrdenada(getNewSugestor()), new FitnessMatrix(), new PadronizaCG());
	}

	private static Executar<EstruturaMatrix, ParametroEntrada, SugestaoMatrix> getExeMatrix() {
		return new Executar<EstruturaMatrix, ParametroEntrada, SugestaoMatrix>() {

			@Override
			public SugestaoMatrix apply(CodigoGenEvo<EstruturaMatrix> arg0, ParametroEntrada arg1) {
				StringBuilder sb = new StringBuilder();

				for (EstruturaMatrix estruturaMatrix : arg0) {
					sb.append(estruturaMatrix.getDs() + "--" + estruturaMatrix.getId() + "\n");
				}

				Database.execute(sb.toString());

				return null;
			}
		};
	}

	private static Fabricar<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> getNewSugestor() {
		return new Fabricar<EstruturaMatrix, SugestaoMatrix, ParametroEntrada>() {

			@Override
			public EntidadeEvo<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> get() {
				return new Sugestor();
			}
		};
	}

	public Integer getQtUso() {
		return qtUso;
	}

	public Integer getQtAcerto() {
		return qtAcerto;
	}
}
