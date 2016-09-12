package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.List;

import br.com.matrix.subAlgoritmo.Operador;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;

public abstract class OperadorBooleano extends Operador<Boolean> {

    public OperadorBooleano(List<MetaInfoAssinatura> param) {
	super(param);
	result = false;
    }
}
