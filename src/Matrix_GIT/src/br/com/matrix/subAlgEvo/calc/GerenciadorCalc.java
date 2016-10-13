package br.com.matrix.subAlgEvo.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import javax.swing.JOptionPane;

import br.com.matrix.evo.EntidadeEvo;
import br.com.matrix.evo.padrao.CondicaoAgrupamentoPadrao;
import br.com.matrix.evo.padrao.CondicaoRemocaoFracao;
import br.com.matrix.evo.suporte.CondicaoAgrupamentoEvo;
import br.com.matrix.evo.suporte.CondicaoFimEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;
import br.com.matrix.subAlgEvo.GerenciadorSubAlg;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.OperadorNumerico.Divisao;
import br.com.matrix.subAlgoritmo.OperadorNumerico.EntradaNumerica;
import br.com.matrix.subAlgoritmo.OperadorNumerico.Multiplicacao;
import br.com.matrix.subAlgoritmo.OperadorNumerico.Soma;
import br.com.matrix.subAlgoritmo.OperadorNumerico.TrocaSinal;

public class GerenciadorCalc extends GerenciadorSubAlg<Double, Void, GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void>> {

	public Supplier<Double> getEntrada() {

		Random r = new Random();

		Double result = Double.valueOf(r.nextInt(10));
		Supplier<Double> entrada = new Supplier<Double>() {

			@Override
			public Double get() {
				Double d = result;
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
		List<SubAlgoritmo<?>> genStart = new ArrayList<>();

		genStart.add(new Divisao());
		genStart.add(new Divisao());
		genStart.add(new Divisao());
		genStart.add(new Divisao());
		genStart.add(new Divisao());
		genStart.add(new Multiplicacao());
		genStart.add(new Multiplicacao());
		genStart.add(new TrocaSinal());
		genStart.add(new TrocaSinal());
		genStart.add(new TrocaSinal());
		genStart.add(new TrocaSinal());
		genStart.add(new Soma());
		genStart.add(new Soma());
		genStart.add(new Soma());
		genStart.add(new Soma());
		genStart.add(new TrocaSinal());
		genStart.add(new TrocaSinal());
		genStart.add(new Soma());
		genStart.add(new EntradaNumerica(getEntrada()));
		genStart.add(new EntradaNumerica(getEntrada()));
		genStart.add(new EntradaNumerica(getEntrada()));
		genStart.add(new EntradaNumerica(getEntrada()));
		genStart.add(new EntradaNumerica(getEntrada()));

		return genStart;
	}

	public GerenciadorCalc() {

		while (getLE().size() <= 30) {
			try {
				getLE().add(new EntidadeCalc(getGenPool(), getGenStart(), 10, this));
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
		return 30 - getLE().size();
	}

	@Override
	public void rodarLE(CondicaoFimEvo<GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void>> cF) {
		while (cF.test(getLE())) {
			padronizaLE();
			removerLE(new CondicaoRemocaoFracao<>(2d));
			CondicaoAgrupamentoEvo<SubAlgoritmo<?>, Double, Void> ca = (CondicaoAgrupamentoPadrao
					.getCondicaoAgrupamentoPar());
			reproduzirLE(ca, calculaQtRep());
			for (EntidadeEvo<SubAlgoritmo<?>, Double, Void> ec : getLE()) {
				ec.mutar();
			}
			padronizaLE();
			
			
			
			getLE().sort();			
			for (EntidadeEvo<?, ?, ?> sa : getLE()) {
				System.out.println(" | " + sa.getFitness().get().intValue() + "_" + sa.executar(null));
				System.out.println(sa.getCG().get(0));
				System.out.println();
			}
			System.out.println("_________________________");
		}
	}

	public void rodarLE() {
		CondicaoFimEvo<GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void>> cF = new CondicaoFimEvo<GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void>>() {
			int c = 0;

			@Override
			public boolean test(GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void> arg0) {
				return ++c < 40;
			}
		};

		rodarLE(cF);
	}

}
