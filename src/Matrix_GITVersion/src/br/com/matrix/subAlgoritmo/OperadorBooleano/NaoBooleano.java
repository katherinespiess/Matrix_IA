package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Quantidade;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

public class NaoBooleano extends OperadorBooleano {
    
    public NaoBooleano() {
	super(getParam());
	
    }

    @Override
    public void executar() {
	l.get(0).executar();
	b = !(Boolean) l.get(0).retornar();
    }
    
    private static List<MetaInfoAssinatura> getParam(){
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);    
	l.add(MetaInfo.fabricarAssinatura(Tipo.TP_BOOLEANO, Quantidade.fabricarQt(1, 1)));
	return l;
    }
}
