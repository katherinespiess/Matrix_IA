package br.com.matrix.subAlgoritmo;

import java.util.function.Supplier;

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
    private Supplier<Tp> s;
    
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

}
