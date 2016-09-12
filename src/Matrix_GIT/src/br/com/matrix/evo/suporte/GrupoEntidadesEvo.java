package br.com.matrix.evo.suporte;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

import br.com.matrix.evo.EntidadeEvo;

/**
 * ArrayList de entidades.
 * 
 * @paramReq <G>
 *            - Tipagem do codigo genético
 * @paramReq <R>
 *            - Tipagem do retorno das entidades
 * @paramReq <P>
 *            - Parametro de execucao
 */
public class GrupoEntidadesEvo<G, R, P> extends ArrayList<EntidadeEvo<G, R, P>> {

	private int qtGeracao = 0;
	private int qtGeracaoFE = 0;
	private FitnessEvo fE = null;

	/**
	 * Incrementa a quantidade de geracoes decorridas.
	 */
	public void incQtGeracao() {
		qtGeracao++;
	}

	/**
	 * Incrementa a quantidade de geracoes decorridas com o mesmo Fitness.
	 */
	public void incQtGeracaoFE() {
		qtGeracaoFE++;
	}

	/**
	 * 
	 * @return a quantidade de geracoes decorridas.
	 */
	public int getQtGeracao() {
		return qtGeracao;
	}

	/**
	 * 
	 * @paramReq qtGeracao
	 *            - quantidade de geracoes decorridas.
	 */
	public void setQtGeracao(int qtGeracao) {
		this.qtGeracao = qtGeracao;
	}

	/**
	 * 
	 * @return a quantidade de geracoes decorridas com o mesmo Fitness.
	 */
	public int getQtGeracaoFE() {
		return qtGeracaoFE;
	}

	/**
	 * 
	 * @paramReq qtGeracaoFE
	 *            - quantidade de geracoes decorridas com o mesmo Fitness.
	 */
	public void setQtGeracaoFE(int qtGeracaoFE) {
		this.qtGeracaoFE = qtGeracaoFE;
	}

	/**
	 * 
	 * @return Fitness atribuido como melhor resultado.
	 */
	public FitnessEvo getfE() {
		return fE;
	}

	/**
	 * Atribui um novo fitness e zera o qtGeracaoFE
	 * 
	 * @paramReq fE
	 *            - Fitness atribuido como melhor resultado.
	 */
	public void setFE(FitnessEvo fE) {
		this.fE = fE;
		this.setQtGeracaoFE(0);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5631674319797053408L;

	/**
	 * Ordena pelo melhor fitness
	 */
	public void sort() {
		this.sort(new Comparator<EntidadeEvo<G, R, P>>() {

			@Override
			public int compare(EntidadeEvo<G, R, P> arg0, EntidadeEvo<G, R, P> arg1) {
				return arg0.compareTo(arg1);
			}
		});
	}

	/**
	 * 
	 * @return a entidade com melhor fitness
	 */
	public EntidadeEvo<G, R, P> getFirst() {
		sort();
		return get(0);
	}

	/**
	 * 
	 * @return a entidade com o pior fitness
	 */
	public EntidadeEvo<G, R, P> getLast() {
		sort();
		return get(size() - 1);
	}

	/**
	 * Coloca na console informacoes uteis.
	 */
	public void echo() {
		System.out.println("");
		System.out.println(Calendar.getInstance().getTime());
		System.out.println("Geracao  =" + this.getQtGeracaoFE() + "/" + this.getQtGeracao());
		System.out.println("Execucao =" + this.get(0).executar(null));
		System.out.println("Fitness  =" + this.get(0).getFitness().get());
		System.out.println("Quantidade indv  =" + this.size());
		System.out.print("Codigo   =");
		for (int i = 0; i < this.get(0).getCG().size(); i++) {
			System.out.print((i == 0 ? "" : i == this.get(0).getCG().size() - 1 ? " e " : ", ")
					+ this.get(0).getCG().get(i).toString());
		}
		System.out.println("");
	}
}
