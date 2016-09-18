package br.com.matrix.subAlgoritmo.variavel;

import java.util.function.Supplier;

public class ControladorVariavel<Tp> implements Supplier<Tp>{

    Tp tp;
    
    @Override
    public Tp get() {
	return tp;
    }
    
    public void set(Tp tp){
	this.tp = tp;
    }

}
