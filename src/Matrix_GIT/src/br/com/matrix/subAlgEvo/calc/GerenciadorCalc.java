package br.com.matrix.subAlgEvo.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import javax.swing.JOptionPane;

import br.com.matrix.evo.EntidadeEvo;
import br.com.matrix.evo.padrao.CondicaoAgrupamentoPadrao;
import br.com.matrix.evo.padrao.CondicaoRemocaoFracao;
import br.com.matrix.evo.padrao.EntidadePadrao;
import br.com.matrix.evo.padrao.FitnessPadrao;
import br.com.matrix.evo.padrao.GerarFitness;
import br.com.matrix.evo.suporte.CodigoGenEvo;
import br.com.matrix.evo.suporte.CondicaoAgrupamentoEvo;
import br.com.matrix.evo.suporte.CondicaoFimEvo;
import br.com.matrix.evo.suporte.Executar;
import br.com.matrix.evo.suporte.FitnessEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;
import br.com.matrix.subAlgEvo.GerenciadorSubAlg;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;
import br.com.matrix.subAlgoritmo.OperadorNumerico.Divisao;
import br.com.matrix.subAlgoritmo.OperadorNumerico.EntradaNumerica;
import br.com.matrix.subAlgoritmo.OperadorNumerico.Multiplicacao;
import br.com.matrix.subAlgoritmo.OperadorNumerico.Soma;
import br.com.matrix.subAlgoritmo.OperadorNumerico.TrocaSinal;
import br.com.matrix.subAlgoritmo.variavel.ControladorVariavel;
import br.com.matrix.subAlgoritmo.variavel.Variavel;

public class GerenciadorCalc extends GerenciadorSubAlg<Double, Void, GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void>> {

    public Supplier<Double> getEntrada() {

	Random r = new Random();

	Double result = Double.valueOf(r.nextInt(10));
	Supplier<Double> entrada = new Supplier<Double>() {

	    @Override
	    public Double get() {
		Double d = 4d;
		while (d == null) {
		    try {
			d = Double.valueOf(JOptionPane.showInputDialog("Insira um número qualquer"));
		    } catch (Exception e) {
			System.out.println(e);
			d = null;
		    }
		}
		return d;
	    }
	};

	return entrada;
    }

    public List<SubAlgoritmo<?>> getGenPool() {
	List<SubAlgoritmo<?>> genPool = new ArrayList<>();
	genPool.add(new Divisao());
	genPool.add(new Multiplicacao());
	genPool.add(new Soma());
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	genPool.add(new EntradaNumerica(getEntrada()));
	return genPool;
    }

    public List<SubAlgoritmo<?>> getGenStart() {
	ControladorVariavel<Double> cs = new ControladorVariavel<>();
	List<SubAlgoritmo<?>> genStart = new ArrayList<>();
	genStart.add(new Divisao());
	genStart.add(new Divisao());
	genStart.add(new Multiplicacao());
	genStart.add(new Multiplicacao());
	genStart.add(new TrocaSinal());
	genStart.add(new TrocaSinal());
	genStart.add(new Multiplicacao());
	genStart.add(new Soma());
	genStart.add(new Soma());
	genStart.add(new EntradaNumerica(getEntrada()));
	genStart.add(new EntradaNumerica(getEntrada()));
	genStart.add(new EntradaNumerica(getEntrada()));
	genStart.add(new EntradaNumerica(getEntrada()));
	genStart.add(new EntradaNumerica(getEntrada()));
	genStart.add(new Divisao());
	genStart.add(new Divisao());
	genStart.add(new Multiplicacao());
	genStart.add(new Multiplicacao());
	genStart.add(new TrocaSinal());
	genStart.add(new TrocaSinal());
	genStart.add(new Multiplicacao());
	genStart.add(new Soma());
	genStart.add(new Soma());
	genStart.add(new EntradaNumerica(getEntrada()));
	genStart.add(new EntradaNumerica(getEntrada()));
	genStart.add(new EntradaNumerica(getEntrada()));
	genStart.add(new EntradaNumerica(getEntrada()));
	genStart.add(new EntradaNumerica(getEntrada()));
	return genStart;
    }

    public GerenciadorCalc() {
	GerarFitness<EntidadePadrao<SubAlgoritmo<?>, Double, Void>, SubAlgoritmo<?>, Double, Void> ftn = new GerarFitness<EntidadePadrao<SubAlgoritmo<?>, Double, Void>, SubAlgoritmo<?>, Double, Void>() {

	    @Override
	    public FitnessEvo apply(EntidadePadrao<SubAlgoritmo<?>, Double, Void> t) {
		return new FitnessPadrao(t.executar(null), 10d);
	    }

	};

	Executar<SubAlgoritmo<?>, Void, Double> exe = new Executar<SubAlgoritmo<?>, Void, Double>() {

	    @Override
	    public Double apply(CodigoGenEvo<SubAlgoritmo<?>> arg0, Void arg1) {
		Double d = null;

		for (SubAlgoritmo<?> sa : arg0) {
		    if (!sa.isExecutado() && sa.isPreparado()) {
			sa.executar();
			if (sa.retornar() != null && sa.getMetaInfo().getReturnTp().equals(Tipo.TP_NUMERICO))
			    d = (Double) sa.retornar();
			if (d != null)
			    break;
		    }
		}

		for (SubAlgoritmo<?> sa : arg0) {
		    sa.resetExecutado();
		}

		return d;
	    }

	};

	while (getLE().size() <= 30) {
	    try {
		getLE().add(new EntidadeCalc(exe, ftn, getGenStart(), getGenPool(), 10));
	    } catch (Exception e) {
	    }
	}
    }

    private void padronizaLE() {
	for (int i = 0; i < getLE().size(); i++) {
	    try {
		getLE().get(i).padronizaCG();
		for (int j = 0; j < getLE().get(i).getCG().size(); j++) {
		    getLE().get(i).getCG().get(j).resetExecutado();
		}
	    } catch (IllegalArgumentException e) {
		getLE().remove(i);
		i--;
	    }
	}
    }

    private int calculaQtRep() {
	return 10 - getLE().size();
    }

    @Override
    public void rodarLE(CondicaoFimEvo<GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void>> cF) {
	while (cF.test(getLE())) {
	    for (int i = 0; i < getLE().size(); i++) {
		padronizaLE();
		removerLE(new CondicaoRemocaoFracao<>(2d));
//		CondicaoAgrupamentoEvo<SubAlgoritmo<?>, Double, Void> ca = CondicaoAgrupamentoPadrao
//			.getCondicaoAgrupamentoLider(CondicaoAgrupamentoPadrao.getCondicaoAgrupamentoPar());
		CondicaoAgrupamentoEvo<SubAlgoritmo<?>, Double, Void> ca = (CondicaoAgrupamentoPadrao.getCondicaoAgrupamentoPar());
		reproduzirLE(ca, calculaQtRep());
		padronizaLE();
		for (EntidadeEvo<?, ?, ?> sa : getLE()) {
		    System.out.print(" | " + sa.executar(null));
		}
		System.out.println();
	    }
	}
    }

    public void rodarLE() {
	CondicaoFimEvo<GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void>> cF = new CondicaoFimEvo<GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void>>() {
	    int c = 0;

	    @Override
	    public boolean test(GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void> arg0) {
		c++;
		boolean b = false;

		for (int i = 0; i < arg0.size(); i++) {
		    EntidadeEvo<?, ?, ?> e = arg0.get(i);
		    try {
			EntidadeCalc eCalc = (EntidadeCalc) e;
			if (eCalc.isFinalizar()) {
			    b = true;
			    break;
			}
		    } catch (Exception ex) {
			arg0.remove(e);
			i--;
		    }
		}

		return c < 10 || b;
	    }
	};

	rodarLE(cF);
    }

}
