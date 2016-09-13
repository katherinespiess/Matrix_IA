package br.com.matrix.subAlgoritmo;

import java.util.function.Supplier;

public class Entrada<Tp> extends Operador<Tp>{

    private Supplier<Tp> s;
    
    public Entrada(Supplier<Tp> s, Class<Tp> tp) {
	super(null, tp);
	this.s = s;
    }

    @Override
    public void executar() {
	result = s.get();
    }

    @Override
    public boolean isPreparado() {
	return s != null;
    }

}
