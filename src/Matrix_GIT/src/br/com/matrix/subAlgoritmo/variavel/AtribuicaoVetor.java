package br.com.matrix.subAlgoritmo.variavel;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.Operador;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Quantidade;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

public class AtribuicaoVetor<Tp> extends Operador<Void> {

    ControladorVetor<Tp> s;

    public AtribuicaoVetor(ControladorVetor<Tp> s, Class<Tp> tp) {
	super(getParam(tp), Void.class);
	this.s = s;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void executar() {
	List<Object> r = new ArrayList<>();
	for (SubAlgoritmo<?> sa : paramEntrada) {
	    r.add(sa.retornar());
	}
	for (Object o : r) {
		if (getMetaInfo().getParam().get(0).getReturnTp().equals(new Tipo(o.getClass()))){
		    r.remove(o);
		    List<Double> posVetor = new ArrayList<>();
		    for (Object o2 : r) {
			posVetor.add((Double) o2);
		    }
		    s.set((Tp) o, posVetor);   
		}
	}
    }

    private static List<MetaInfoAssinatura> getParam(Class<?> tp) {
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);
	l.add(MetaInfo.fabricarAssinatura(new Tipo(tp), Quantidade.fabricarQt(1, 1)));
	l.add(MetaInfoAssinatura.fabricar(Tipo.TP_NUMERICO, Quantidade.fabricarQt(1, Integer.MAX_VALUE)));
	return l;
    }

}
