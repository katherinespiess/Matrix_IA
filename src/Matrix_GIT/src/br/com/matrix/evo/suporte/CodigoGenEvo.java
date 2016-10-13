package br.com.matrix.evo.suporte;

import java.util.ArrayList;

import br.com.matrix.caixeiro.FunctionalList;
import br.com.matrix.evo.GerenciadorEvo;

/**
 * ArrayList de Alelos genétcos.
 * 
 * @paramReq <G>
 *            - Tipagem do código genético
 */
public class CodigoGenEvo<G> extends ArrayList<G> implements FunctionalList<G> {

    GerenciadorEvo<?, ?, ?, ?> ger;
    
    public CodigoGenEvo(GerenciadorEvo<?, ?, ?, ?> ger) {
	this.ger = ger;
    }
    
    private static final long serialVersionUID = 1077258367168846110L;
}
