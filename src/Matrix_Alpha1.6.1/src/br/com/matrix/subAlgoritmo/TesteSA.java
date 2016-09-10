package br.com.matrix.subAlgoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import br.com.matrix.subAlgoritmo.OperadorBooleano.EntradaBooleana;
import br.com.matrix.subAlgoritmo.OperadorBooleano.OuBooleano;

public class TesteSA {

    public static void main(String[] args) {
	EntradaBooleana b1 = new EntradaBooleana(new Supplier<Boolean>() {
	    
	    @Override
	    public Boolean get() {
		return true;
	    }
	});
	
	EntradaBooleana b2 = new EntradaBooleana(new Supplier<Boolean>() {
	    
	    @Override
	    public Boolean get() {
		return true;
	    }
	});
	
	List<SubAlgoritmo> p = new ArrayList<>();
	p.add(b1);
	p.add(b2);
	
	OuBooleano b3 = new OuBooleano();
	b3.preparar(p);
	b3.executar();
	
	System.out.println(b3.retornar());
    }

}
