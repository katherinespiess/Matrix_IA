package br.com.matrix.subAlgoritmo.OperadorLogicoNumerico;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Quantidade;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;
import br.com.matrix.subAlgoritmo.OperadorBooleano.OperadorBooleano;

public class IgualLogicoNumerico extends OperadorBooleano {

    public IgualLogicoNumerico() {
	super(getParam());
    }

    
    private static List<MetaInfoAssinatura> getParam(){
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);    
	l.add(MetaInfo.fabricarAssinatura(Tipo.TP_NUMERICO, Quantidade.fabricarQt(2, Integer.MAX_VALUE)));
	return l;
    }


    @Override
    public void executar() {
	result = true;
	
	SubAlgoritmo<?> sa1 = paramEntrada.get(0);
	sa1.executar();
	
	for (int i = 1; i < paramEntrada.size(); i++) {
	    paramEntrada.get(i).executar();
	    paramEntrada.get(i).retornar().equals(sa1.retornar());
	}
    }
}
