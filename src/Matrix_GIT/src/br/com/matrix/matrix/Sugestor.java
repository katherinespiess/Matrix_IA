package br.com.matrix.matrix;

import java.util.List;

import br.com.matrix.evo.EntidadeEvo;
import br.com.matrix.evo.GerenciadorEvo;
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

	public Sugestor(List<EstruturaMatrix> pG, int qtGenes, GerenciadorEvo<?, ?, ?, ?> ger) {
		super(getExeMatrix(), EntidadePadrao.getMutPadraoTrocaComplexa(),
				EntidadePadrao.getRepOrdenada(getNewSugestor(ger)), new FitnessMatrix(), new PadronizaCG(), pG, qtGenes, ger);
	}

	public Sugestor(GerenciadorEvo<?, ?, ?, ?> ger) {
		super(getExeMatrix(), EntidadePadrao.getMutPadraoTrocaComplexa(),
				EntidadePadrao.getRepOrdenada(getNewSugestor(ger)), new FitnessMatrix(), new PadronizaCG(), ger);
	}

	private static Executar<EstruturaMatrix, ParametroEntrada, SugestaoMatrix> getExeMatrix() {
		return new Executar<EstruturaMatrix, ParametroEntrada, SugestaoMatrix>() {

			
			
			@Override
			public SugestaoMatrix apply(CodigoGenEvo<EstruturaMatrix> arg0, ParametroEntrada arg1) {
				StringBuilder sb = new StringBuilder();

				for (EstruturaMatrix estruturaMatrix : arg0) {
					sb.append(estruturaMatrix.getDs() + "--" + estruturaMatrix.getId() + "\n");
					if (arg0.indexOf(estruturaMatrix)>0){
						sb.append("union\n");
					}
				}		
				return new SugestaoMatrix(Database.execute(sb.toString()).get(0));
			}
		};
	}

	private static Fabricar<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> getNewSugestor(GerenciadorEvo<?, ?, ?, ?> ger) {
		return new Fabricar<EstruturaMatrix, SugestaoMatrix, ParametroEntrada>() {

			@Override
			public EntidadeEvo<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> get() {
				return new Sugestor(ger);
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
