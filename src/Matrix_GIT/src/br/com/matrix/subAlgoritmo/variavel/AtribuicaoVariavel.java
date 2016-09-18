package br.com.matrix.subAlgoritmo.variavel;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.Operador;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Quantidade;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

public class AtribuicaoVariavel<Tp> extends Operador<Void> {

    ControladorVariavel<Tp> s;

    public AtribuicaoVariavel(ControladorVariavel<Tp> s, Class<Tp> tp) {
	super(getParam(tp), Void.class);
	this.s = s;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void executar() {
	Object o = paramEntrada.get(0).retornar();
	if (getMetaInfo().getParam().get(0).getReturnTp().equals(new Tipo(o.getClass())))
	    s.set((Tp) o);
    }

    private static List<MetaInfoAssinatura> getParam(Class<?> tp) {
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);
	l.add(MetaInfo.fabricarAssinatura(new Tipo(tp), Quantidade.fabricarQt(1, 1)));
	return l;
    }

}
