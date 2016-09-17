package br.com.matrix.subAlgoritmo.OperadorNumerico;

import java.util.List;

import br.com.matrix.subAlgoritmo.Operador;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;

public abstract class OperadorNumerico extends Operador<Double> {

    public OperadorNumerico(List<MetaInfoAssinatura> param) {
	super(param, Double.class);
    }
}
