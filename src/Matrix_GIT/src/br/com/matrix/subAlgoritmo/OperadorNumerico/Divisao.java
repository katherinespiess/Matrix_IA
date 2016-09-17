package br.com.matrix.subAlgoritmo.OperadorNumerico;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Quantidade;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

public class Divisao extends OperadorNumerico {

    public Divisao(List<MetaInfoAssinatura> param) {
	super(getParam());	
    }

    @Override
    public void executar() {
	result = 0d;
	for (SubAlgoritmo<?> sa : paramEntrada) {
	    result /= (Double) sa.retornar();
	}
    }


    private static List<MetaInfoAssinatura> getParam() {
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);
	l.add(MetaInfo.fabricarAssinatura(Tipo.TP_NUMERICO, Quantidade.fabricarQt(2, Integer.MAX_VALUE)));
	return l;
    }
}
