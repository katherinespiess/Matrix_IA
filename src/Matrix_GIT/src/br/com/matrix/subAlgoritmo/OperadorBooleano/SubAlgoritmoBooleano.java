package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.List;

import br.com.matrix.subAlgoritmo.Operador;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;

public abstract class SubAlgoritmoBooleano extends Operador<Boolean> {

    public SubAlgoritmoBooleano(List<MetaInfoAssinatura> param) {
	super(param, Boolean.class);
    }
}
