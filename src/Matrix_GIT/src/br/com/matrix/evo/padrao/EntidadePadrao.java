package br.com.matrix.evo.padrao;

import java.util.List;
import java.util.Random;

import br.com.matrix.evo.*;
import br.com.matrix.evo.suporte.*;

/**
 * Implementação padrão da entidadeEVO
 * 
 * @author GustavoHenrique
 *
 * @paramReq <G>
 *            - Tipagem do codigo genético
 * @paramReq <R>
 *            - Tipagem do retorno das entidades
 * @paramReq <P>
 *            - Parametro de execucao
 */
public class EntidadePadrao<G, R, P> implements EntidadeEvo<G, R, P> {

    private CodigoGenEvo<G> cG;
    private Executar<G, P, R> exe;
    private Mutar<G> mut;
    private reproduzir<G, R, P> rep;
    private GerarFitness<EntidadePadrao<G, R, P>, G, R, P> ftn;
    private PadronizarCodigoGenetico<G> pad;

    private R ultimaExec;

    public static final Random r = new Random();

    /**
     * Construtor completo.
     * 
     * @paramReq exe
     *            - Execução da entidade a partir do código genético e dos
     *            parâmetros passados.
     * @paramReq mut
     *            - Mutacao.
     * @paramReq rep
     *            - Reproducao.
     * @paramReq ftn
     *            - Fitness.
     * @paramReq pad
     *            - Padronização do código genérico.
     * @paramReq pG
     *            - Lista de genes à serem usados (selecionados em ordem
     *            aleatória).
     * @paramReq qtGenes
     *            - Quantidade de genes à serem usados. Se 0, todos os da pG, se
     *            <0 uma quantidade aleatória menor que o total da pG
     */
    public EntidadePadrao(Executar<G, P, R> exe, Mutar<G> mut, reproduzir<G, R, P> rep,
	    GerarFitness<EntidadePadrao<G, R, P>, G, R, P> ftn, PadronizarCodigoGenetico<G> pad, List<G> pG,
	    int qtGenes) {
	this.exe = exe;
	this.mut = mut;
	this.rep = rep;
	this.ftn = ftn;

	int j = qtGenes;

	if (qtGenes == 0) {
	    j = pG.size();
	} else if (qtGenes < 0) {
	    j = r.nextInt(pG.size());
	}
	List<G> p = pG.subList(0, pG.size());
	for (int i = 0; i < j; i++) {
	    int n = r.nextInt(p.size());
	    getCG().add(p.get(n));
	    p.remove(n);
	}
    }

    /**
     * Construtor simplificago, sem tratamento para os genes.
     * 
     * @paramReq exe
     *            - Execução da entidade a partir do código genético e dos
     *            parâmetros passados.
     * @paramReq mut
     *            - Mutacao.
     * @paramReq rep
     *            - Reproducao.
     * @paramReq ftn
     *            - Fitness.
     * @paramReq pad
     *            - Padronização do código genérico.
     */
    public EntidadePadrao(Executar<G, P, R> exe, Mutar<G> mut, reproduzir<G, R, P> rep,
	    GerarFitness<EntidadePadrao<G, R, P>, G, R, P> ftn, PadronizarCodigoGenetico<G> pad) {
	this.exe = exe;
	this.mut = mut;
	this.rep = rep;
	this.ftn = ftn;
    }

    @Override
    public CodigoGenEvo<G> getCG() {
	if (cG == null)
	    cG = new CodigoGenEvo<G>();
	return cG;
    }

    @Override
    public FitnessEvo getFitness() {
	return ftn.apply(this);
    }

    @Override
    public R executar(P p) {
	ultimaExec = exe.apply(getCG(), p);
	return ultimaExec;
    }

    @Override
    public GrupoEntidadesEvo<G, R, P> reproduzir(GrupoEntidadesEvo<G, R, P> lG, int qt) {
	return rep.apply(lG, qt);
    }

    @Override
    public void mutar() {
	cG = mut.apply(getCG());
    }

    @Override
    public void padronizaCG() {
	cG = pad.apply(getCG());
    }

    public Executar<G, P, R> getExe() {
	return exe;
    }

    public Mutar<G> getMut() {
	return mut;
    }

    public reproduzir<G, R, P> getRep() {
	return rep;
    }

    public GerarFitness<EntidadePadrao<G, R, P>, G, R, P> getFtn() {
	return ftn;
    }

    public PadronizarCodigoGenetico<G> getPad() {
	return pad;
    }

    /**
     * 
     * @paramReq fabrica
     *            - Supplier para conseguir uma nova instancia de entidadeEvo,
     *            sem haver importancia para o codigo genetico desse.
     * 
     * @return - Reproducao de mescla simples entes os objetos
     */
    public static <G, R, P> reproduzir<G, R, P> getRepPadrao(Fabricar<G, R, P> fabrica) {
	return new reproduzir<G, R, P>() {

	    @Override
	    public GrupoEntidadesEvo<G, R, P> apply(GrupoEntidadesEvo<G, R, P> t, Integer qt) {

		GrupoEntidadesEvo<G, R, P> result = new GrupoEntidadesEvo<G, R, P>();
		EntidadeEvo<G, R, P> eV;
		for (int i = 0; i < qt; i++) {
		    eV = fabrica.get();

		    for (int j = 0; j < t.getFirst().getCG().size(); j++) {
			G g;
			int k = r.nextInt(t.size());
			do {
			    CodigoGenEvo<G> cG = t.get(k % (t.size())).getCG();
			    g = cG.get(j % cG.size());
			    k++;
			} while (g == null);
			eV.getCG().add(g);
		    }

		    eV.padronizaCG();
		    result.add(eV);
		}

		return result;
	    }
	};
    }

    /**
     * 
     * @paramReq fabrica
     *            - Supplier para conseguir uma nova instancia de entidadeEvo,
     *            sem haver importancia para o codigo genetico desse.
     * 
     * @return - Reproducao onde os objetos são ordenados pelo maior fitness, o
     *         primeiro tem 50% de chance, o segundo metade e assim à diante.
     */
    public static <G, R, P> reproduzir<G, R, P> getRepOrdenada(Fabricar<G, R, P> fabrica) {
	return new reproduzir<G, R, P>() {

	    @Override
	    public GrupoEntidadesEvo<G, R, P> apply(GrupoEntidadesEvo<G, R, P> t, Integer qt) {

		GrupoEntidadesEvo<G, R, P> result = new GrupoEntidadesEvo<G, R, P>();
		EntidadeEvo<G, R, P> eV;
		for (int i = 0; i < qt; i++) {
		    eV = fabrica.get();

		    for (int j = 0; j < t.getFirst().getCG().size(); j++) {
			G g = null;
			int l = 0;
			do {
			    if (r.nextBoolean())
				g = t.get(l % t.size()).getCG().get(j);
			    l++;
			} while (g == null);
			eV.getCG().add(g);
		    }

		    eV.padronizaCG();
		    result.add(eV);
		}

		return result;
	    }
	};
    }

    /**
     * Mutacao.
     * 
     * @return mutação de troca simples, um gene aleatório é trocado de lugar
     *         com outro.
     */
    public static <G> Mutar<G> getMutPadraoTrocaSimples() {
	return new Mutar<G>() {

	    @Override
	    public CodigoGenEvo<G> apply(CodigoGenEvo<G> t) {

		CodigoGenEvo<G> cG = t;

		int i = r.nextInt(cG.size());
		int j = r.nextInt(cG.size());
		G c = cG.get(i);
		cG.set(i, cG.get(j));
		cG.set(j, c);

		return cG;
	    }
	};
    }

    /**
     * Mutacao.
     * 
     * @return mutação de troca simples, um gene aleatório é trocado de lugar
     *         com outro adjacente.
     */
    public static <G> Mutar<G> getMutPadraoTrocaAnexo() {
	return new Mutar<G>() {

	    @Override
	    public CodigoGenEvo<G> apply(CodigoGenEvo<G> t) {

		CodigoGenEvo<G> cG = t;

		int i = r.nextInt(cG.size());
		int j = i % cG.size();
		G c = cG.get(i);
		cG.set(i, cG.get(j));
		cG.set(j, c);

		return cG;
	    }
	};
    }

    /**
     * Mutacao.
     * 
     * @return mutação de troca complexa, um gene aleatório é trocado de lugar
     *         empurrando os demais para as vagas subsequentes.
     */
    public static <G> Mutar<G> getMutPadraoTrocaComplexa() {
	return new Mutar<G>() {

	    @Override
	    public CodigoGenEvo<G> apply(CodigoGenEvo<G> t) {

		int i = r.nextInt(t.size());
		int j = r.nextInt(t.size());

		if (i > j) {
		    int k = i;
		    i = j;
		    j = k;
		}

		for (int k = i; k < j; k++) {
		    G c = t.get(k);
		    t.set(k, t.get((k + 1) % t.size()));
		    t.set((k + 1) % t.size(), c);
		}

		return t;
	    }
	};
    }

}
