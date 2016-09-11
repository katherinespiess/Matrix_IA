package br.com.matrix.subAlgoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import br.com.matrix.subAlgoritmo.OperadorBooleano.EntradaBooleana;
import br.com.matrix.subAlgoritmo.OperadorBooleano.NaoBooleano;

public class TesteSA {

    public static void main(String[] args) {
	EntradaBooleana b1 = new EntradaBooleana(new Supplier<Boolean>() {
	    
	    @Override
	    public Boolean get() {
		return false;
	    }
	});
	
	EntradaBooleana b2 = new EntradaBooleana(new Supplier<Boolean>() {
	    
	    @Override
	    public Boolean get() {
		return true;
	    }
	});
	
	List<SubAlgoritmo<?>> p = new ArrayList<>();
	p.add(b1);
	p.add(b2);
	
	NaoBooleano b3 = new NaoBooleano();
	b3.preparar(p);
	b3.executar();
	
	System.out.println(b3.retornar());
    }

}
