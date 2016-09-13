package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.function.Supplier;

import br.com.matrix.subAlgoritmo.Entrada;

public class EntradaBooleana extends Entrada<Boolean>{
    
    public EntradaBooleana(Supplier<Boolean> s) {
	super(s, Boolean.class);
    }
}
