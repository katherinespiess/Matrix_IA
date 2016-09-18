package br.com.matrix.subAlgoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import br.com.matrix.subAlgoritmo.OperadorBooleano.EntradaBooleana;
import br.com.matrix.subAlgoritmo.variavel.AtribuicaoVariavel;
import br.com.matrix.subAlgoritmo.variavel.ControladorVariavel;
import br.com.matrix.subAlgoritmo.variavel.Variavel;

public class TesteSA {

    public static void main(String[] args) {
	ControladorVariavel<Boolean> cv = new ControladorVariavel<>();
	Variavel<Boolean> v = new Variavel<>(cv, Boolean.class);
	AtribuicaoVariavel<Boolean> av = new AtribuicaoVariavel<>(cv, Boolean.class);
	
	List<SubAlgoritmo<?>> l = new  ArrayList<>();
	l.add(new EntradaBooleana(new Supplier<Boolean>() {

	    @Override
	    public Boolean get() {
		// TODO Auto-generated method stub
		return false;
	    }
	}));
	
	l.get(0).executar();
	
	av.preparar(l);
	
	av.executar();
	
	v.executar();
	
	System.out.println(v.retornar());
    }

}
