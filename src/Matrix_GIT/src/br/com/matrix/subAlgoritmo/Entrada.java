package br.com.matrix.subAlgoritmo;

import java.util.function.Supplier;

import br.com.matrix.subAlgoritmo.variavel.AtribuicaoVariavel;
import br.com.matrix.subAlgoritmo.variavel.Variavel;

/**
 * Operador de input genérico.
 * 
 * @author GustavoHenrique
 *
 * @param <Tp> - Tipagem do retorno 
 */
public class Entrada<Tp> extends Operador<Tp>{

    /**
     * Suplier de imput.
     */
    protected Supplier<Tp> s;
    
    /**
     * Construtor
     * 
     * @param s suplier para a entrada
     * @param tp tipo de retorno.
     */
    public Entrada(Supplier<Tp> s, Class<Tp> tp) {
	super(null, tp);
	this.s = s;
    }

    /**
     * Atribui à variável de controle o <code>.get()</code> do suplier.
     */
    @Override
    public void executar() {
	result = s.get();
    }

    /**
     * verifica se o Suplier é não nulo.
     */
    @Override
    public boolean isPreparado() {
	return s != null;
    }
    
    public Supplier<Tp> getSup() {
	return s;
    }

    @Override
    public String toString() {
	if (isPreparado() && isExecutado()){
	    return retornar().toString();
	}else{
	    return "in("+super.toString().substring(super.toString().indexOf('@')+1)+")";
	}
	
    }

    @Override
    public boolean isChamado(SubAlgoritmo<?> sa) {
	if (this instanceof Variavel<?>){
	    if (sa instanceof AtribuicaoVariavel<?>)
	    	return ((Variavel<?>) this).getSup().equals(((AtribuicaoVariavel<?>)sa).getSup());
	}
	return false;
    }

}
