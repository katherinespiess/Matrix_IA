package br.com.matrix.subAlgoritmo;

import java.util.List;
import java.util.function.Supplier;

import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;

/**
 * Operador de input gen�rico.
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
    public Entrada(List<MetaInfoAssinatura> lp, Supplier<Tp> s, Class<Tp> tp) {
	super(lp, tp);
	this.s = s;
    }
    
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
     * Atribui � vari�vel de controle o <code>.get()</code> do suplier.
     */
    @Override
    public void executar() {
	result = s.get();
    }

    /**
     * verifica se o Suplier � n�o nulo.
     */
    @Override
    public boolean isPreparado() {
	return s != null;
    }

}
