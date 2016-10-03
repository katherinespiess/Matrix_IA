package br.com.matrix.subAlgoritmo.variavel;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.Entrada;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Quantidade;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

public class Vetor<Tp> extends Entrada<Tp> {

    public Vetor(ControladorVetor<Tp> s, Class<Tp> tp) {
	super(getParam(), s, tp);
    }

    private static List<MetaInfoAssinatura> getParam() {
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);	
	l.add(MetaInfoAssinatura.fabricar(Tipo.TP_NUMERICO, Quantidade.fabricarQt(1, Integer.MAX_VALUE)));
	return l;
    }
}
