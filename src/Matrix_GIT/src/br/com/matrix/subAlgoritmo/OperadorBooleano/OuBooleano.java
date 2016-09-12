package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Quantidade;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

public class OuBooleano extends OperadorBooleano {
    
    public OuBooleano() {
	super(getParam());
	
    }

    @Override
    public void executar() {
	result = false;
	for (SubAlgoritmo<? extends Object> sa : paramEntrada) {
	    sa.executar();
	    if ((Boolean) sa.retornar()) {
		result = true;
		break;
	    }
	}
    }
    
    private static List<MetaInfoAssinatura> getParam(){
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);    
	l.add(MetaInfo.fabricarAssinatura(Tipo.TP_BOOLEANO, Quantidade.fabricarQt(1, Integer.MAX_VALUE)));
	return l;
    }
}
