package br.com.matrix.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.matrix.aplicacao.ParametroEntrada;
import br.com.matrix.banco.Database;
import br.com.matrix.banco.tabelas.Sugestores;
import br.com.matrix.banco.tabelas.interfaces.IArmazenavel;
import br.com.matrix.banco.tabelas.interfaces.ICampo;
import br.com.matrix.banco.tabelas.interfaces.IColuna;
import br.com.matrix.banco.tabelas.interfaces.ILinha;
import br.com.matrix.banco.tabelas.interfaces.ITabela;
import br.com.matrix.evo.EntidadeEvo;
import br.com.matrix.evo.GerenciadorEvo;
import br.com.matrix.evo.padrao.EntidadePadrao;
import br.com.matrix.evo.suporte.CodigoGenEvo;
import br.com.matrix.evo.suporte.Executar;
import br.com.matrix.evo.suporte.Fabricar;

/**
 * 
 * Entidade matrix, retorna uma String.
 * 
 */
public class Sugestor extends EntidadePadrao<EstruturaMatrix, SugestaoMatrix, ParametroEntrada>
		implements IArmazenavel {

	ILinha val;

	public Sugestor(List<EstruturaMatrix> pG, int qtGenes, GerenciadorEvo<?, ?, ?, ?> ger) {
		super(getExeMatrix(), EntidadePadrao.getMutPadraoTrocaComplexa(),
				EntidadePadrao.getRepOrdenada(getNewSugestor(ger)), new FitnessMatrix(), new PadronizaCG(), pG, qtGenes,
				ger);
	}

	public Sugestor(GerenciadorEvo<?, ?, ?, ?> ger) {
		super(getExeMatrix(), EntidadePadrao.getMutPadraoTrocaComplexa(),
				EntidadePadrao.getRepOrdenada(getNewSugestor(ger)), new FitnessMatrix(), new PadronizaCG(), ger);
	}

	public Sugestor(int id, GerenciadorEvo<?, ?, ?, ?> ger) {
		super(getExeMatrix(), EntidadePadrao.getMutPadraoTrocaComplexa(),
				EntidadePadrao.getRepOrdenada(getNewSugestor(ger)), new FitnessMatrix(), new PadronizaCG(), ger);

		val = Database
				.execute(
						Database.selectBuilder(getTb().getColunas()) + " where " + getTb().getApelido() + ".id = " + id)
				.get(0);
		List<Integer> listaId = new ArrayList<Integer>();
		List<ILinha> select = Database.execute("Select id_e from sugestores_has_estruturas where id_s = " + id);

		for (ILinha li : select) {
			for (ICampo ca : li.getCampos()) {
				if (ca.getColuna().getNm().equalsIgnoreCase("id_e"))
					listaId.add(Integer.valueOf(ca.getValor().toString()));
			}
		}

		for (Integer idE : listaId) {
			EstruturaMatrix em = new EstruturaMatrix(idE);
			getCG().add(em);

		}
	}

	private static Executar<EstruturaMatrix, ParametroEntrada, SugestaoMatrix> getExeMatrix() {
		return new Executar<EstruturaMatrix, ParametroEntrada, SugestaoMatrix>() {

			@Override
			public SugestaoMatrix apply(CodigoGenEvo<EstruturaMatrix> arg0, ParametroEntrada arg1) {
				StringBuilder sb = new StringBuilder();

				for (EstruturaMatrix estruturaMatrix : arg0) {
					if (arg0.indexOf(estruturaMatrix) > 0) {
						sb.append("\nunion\n");
					}
					String select = estruturaMatrix.getDs();

					select = select.replace(":lastWord", "'" + arg1.getLastWord() + "'");
					select = select.replace(":acWord", "'" + arg1.getAcWord() + "'");
					select = select.replace(":all", "'" + arg1.getAll() + "'");

					sb.append(select);
				}
				ILinha s = Database.execute(sb.toString()).get(0);
				return new SugestaoMatrix(s);
			}
		};
	}

	private static Fabricar<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> getNewSugestor(
			GerenciadorEvo<?, ?, ?, ?> ger) {
		return new Fabricar<EstruturaMatrix, SugestaoMatrix, ParametroEntrada>() {

			@Override
			public EntidadeEvo<EstruturaMatrix, SugestaoMatrix, ParametroEntrada> get() {
				return new Sugestor(ger);
			}
		};
	}

	public Integer getQtUso() {
		return Integer.valueOf(getCampoPorNm("Qt_uso").getValor().toString());
	}

	public Integer getQtAcerto() {
		return Integer.valueOf(getCampoPorNm("Qt_acerto").getValor().toString());
	}

	public Boolean getIeAtivo() {
		return Boolean.valueOf(getCampoPorNm("Ie_ativo").getValor().toString());
	}

	@Override
	public ITabela getTb() {
		return Sugestores.get();
	}

	@Override
	public List<IArmazenavel> getDependencias() {
		List<IArmazenavel> r = new ArrayList<>();
		r.addAll(getCG());
		return r;
	}

	@Override
	public HashMap<IColuna, ICampo> getValoresCampo() {
		return val.get();
	}
}
