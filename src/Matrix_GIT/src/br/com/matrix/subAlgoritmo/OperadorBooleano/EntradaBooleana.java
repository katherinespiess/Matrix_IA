package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.function.Supplier;

public class EntradaBooleana extends OperadorBooleano{

    private Supplier<Boolean> s;
    
    public EntradaBooleana(Supplier<Boolean> s) {
	super(null);
	this.s = s;
    }

    @Override
    public void executar() {
	b = s.get();
    }

    @Override
    public boolean isPreparado() {
	return s != null;
    }

}
