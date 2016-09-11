package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Quantidade;
import br.com.matrix.subAlgoritmo.MetaInfo.TipoGenerico;

public class OuExclusivoBooleano extends OperadorBooleano {

    public OuExclusivoBooleano() {
	super(getParam());

    }

    @Override
    public void executar() {
	l.get(0).executar();
	l.get(1).executar();
	b = !((Boolean)l.get(0).retornar()).equals((Boolean)l.get(1).retornar());
    }

    private static List<MetaInfoAssinatura> getParam() {
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);
	l.add(MetaInfo.fabricarAssinatura(TipoGenerico.TP_BOOLEANO, Quantidade.fabricarQt(2, 2)));
	return l;
    }
}
