package br.com.matrix.subAlgoritmo.OperadorNumerico;

import java.util.function.Supplier;

import br.com.matrix.subAlgoritmo.Entrada;

/**
 * Input Booleano
 * 
 * @author GustavoHenrique
 *
 */
public class EntradaNumerica extends Entrada<Double>{
    
    public EntradaNumerica(Supplier<Double> s) {
	super(s, Double.class);
    }
}
