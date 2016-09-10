package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Qt;
import br.com.matrix.subAlgoritmo.MetaInfo.TipoGenerico;

public class OuBooleano extends OperadorBooleano {
    
    public OuBooleano() {
	super(getParam());
	
    }

    @Override
    public void executar() {
	b = false;
	for (SubAlgoritmo<? extends Object> sa : l) {
	    sa.executar();
	    if ((Boolean) sa.retornar()) {
		b = true;
		break;
	    }
	}
    }
    
    private static List<MetaInfoAssinatura> getParam(){
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);    
	l.add(MetaInfo.fabricarAssinatura(TipoGenerico.TP_BOOLEANO, Qt.fabricarQt(1, Integer.MAX_VALUE)));
	return l;
    }
}
