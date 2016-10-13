package br.com.matrix.subAlgoritmo;

import br.com.matrix.subAlgEvo.calc.GerenciadorCalc;

public class TesteSA {

    public static void main(String[] args) {
	GerenciadorCalc g = new GerenciadorCalc();
	g.rodarLE();
//	Supplier<Double> entrada = new Supplier<Double>() {
//
//	    @Override
//	    public Double get() {
//		Double d = 1d;
//		while (d == null) {
//		    try {
//			d = Double.valueOf(JOptionPane.showInputDialog("Insira um número qualquer"));
//		    } catch (Exception e) {
//			System.out.println(e);
//			d = null;
//		    }
//		}
//		return d;
//	    }
//	};
//	ControladorVariavel<Double> cs = new ControladorVariavel<>();
//
//	List<SubAlgoritmo<?>> genPool = new ArrayList<>();
//	genPool.add(new Divisao());
//	genPool.add(new Multiplicacao());
//	genPool.add(new EntradaNumerica(entrada));
//	genPool.add(new EntradaNumerica(entrada));
//	genPool.add(new EntradaNumerica(entrada));
//	genPool.add(new EntradaNumerica(entrada));
//	genPool.add(new EntradaNumerica(entrada));
//	genPool.add(new EntradaNumerica(entrada));
//
//	List<SubAlgoritmo<?>> gen = new ArrayList<>();
//	gen.add(new Divisao());
//	gen.add(new TrocaSinal());
//	gen.add(new TrocaSinal());
//	gen.add(new Multiplicacao());
//	gen.add(new Soma());
//	gen.add(new Soma());
//	gen.add(new EntradaNumerica(entrada));
//	gen.add(new EntradaNumerica(entrada));
//	gen.add(new EntradaNumerica(entrada));
//	gen.add(new Variavel<Double>(cs, Double.class));
//	gen.add(new Variavel<Double>(cs, Double.class));
//	gen.add(new Variavel<Double>(cs, Double.class));
//
//	GerarFitness<EntidadePadrao<SubAlgoritmo<?>, Double, Void>, SubAlgoritmo<?>, Double, Void> ftn = new GerarFitness<EntidadePadrao<SubAlgoritmo<?>, Double, Void>, SubAlgoritmo<?>, Double, Void>() {
//
//	    @Override
//	    public FitnessEvo apply(EntidadePadrao<SubAlgoritmo<?>, Double, Void> t) {
//		return new FitnessEvo() {
//
//		    @Override
//		    public Double get() {
//			Double d = (t.executar(null)) - 42;
//			if (d < 0)
//			    d *= -1;
//			return d;
//		    }
//		};
//	    }
//
//	};
//
//	Executar<SubAlgoritmo<?>, Void, Double> exe = new Executar<SubAlgoritmo<?>, Void, Double>() {
//
//	    @Override
//	    public Double apply(CodigoGenEvo<SubAlgoritmo<?>> arg0, Void arg1) {
//		Double d = null;
//
//		for (SubAlgoritmo<?> sa : arg0) {
//		    if (!sa.isExecutado() && sa.isPreparado()) {
//			sa.executar();
//			if (sa.retornar() != null && sa.getMetaInfo().getReturnTp().equals(Tipo.TP_NUMERICO))
//			    d = (Double) sa.retornar();
//			// JOptionPane.showMessageDialog(null, sa.toString() +
//			// "\n\n" + sa.retornar());
//		    }
//		}
//
//		for (SubAlgoritmo<?> sa : arg0) {
//		    sa.resetExecutado();
//		}
//
//		return d;
//	    }
//
//	};
//
//	GrupoEntidadesEvo<SubAlgoritmo<?>, Double, Void> l = new GrupoEntidadesEvo();
//	EntidadeSubAlgEvo<Double, Void> a = new EntidadeSubAlgEvo<>(exe, ftn, gen, genPool, 8);
//	;
//	for (int i = 0; i < 5; i++) {
//	    gen.add(new Divisao());
//	    gen.add(new TrocaSinal());
//	    gen.add(new TrocaSinal());
//	    gen.add(new Multiplicacao());
//	    gen.add(new Soma());
//	    gen.add(new Soma());
//	    gen.add(new EntradaNumerica(entrada));
//	    gen.add(new EntradaNumerica(entrada));
//	    gen.add(new EntradaNumerica(entrada));
//	    gen.add(new Variavel<Double>(cs, Double.class));
//	    gen.add(new Variavel<Double>(cs, Double.class));
//	    gen.add(new Variavel<Double>(cs, Double.class));
//	    System.out.println(a.getCG().toString());
//	    try {
//		a = new EntidadeSubAlgEvo<>(exe, ftn, gen, genPool, 8);
//		l.add(a);
//	    } catch (IllegalArgumentException e) {
//	    }
//	}
//
//	for (int i = 0; i < l.size(); i++) {
//	    EntidadeSubAlgEvo<Double, Void> evo = (EntidadeSubAlgEvo<Double, Void>) l.get(i);
//	    try {
//		System.out.println(".\n.\nExecutando entidade numero " + l.indexOf(evo) + "\n.\n.");
//		evo.executar(null);
//	    } catch (Exception e) {
//		System.out.println("Erro na execução.\n" + e.getMessage() + "\n.\n.Item removido");
//		l.remove(i);
//		i--;
//	    }
//	}
//
//	boolean b = false;
//	while (!b)
//	    try {
//
//		a = (EntidadeSubAlgEvo<Double, Void>) a.reproduzir(l, 1).get(0);
//		b = true;
//	    } catch (Exception e) {
//		// TODO: handle exception
//	    }
//
//	System.out.println(a.getCG());
//	System.out.println(a.executar(null));
    }
}
