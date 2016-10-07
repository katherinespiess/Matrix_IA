package br.com.matrix.subAlgoritmo.variavel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import br.com.matrix.subAlgoritmo.Operador;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.Quantidade;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

public class AtribuicaoVariavel<Tp> extends Operador<Void> {

    Class<Tp> tpVar;
    
    ControladorVariavel<Tp> s;

    public AtribuicaoVariavel(ControladorVariavel<Tp> s, Class<Tp> tp) {
	super(getParam(tp), Void.class);
	this.s = s;
	this.tpVar = tp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void executar() {
	paramEntrada.get(0).executar();
	Object o = paramEntrada.get(0).retornar();
	if (getMetaInfo().getParam().get(0).getReturnTp().equals(new Tipo(o.getClass())))
	    s.set((Tp) o);
    }

    private static List<MetaInfoAssinatura> getParam(Class<?> tp) {
	List<MetaInfoAssinatura> l = new ArrayList<MetaInfoAssinatura>(1);
	l.add(MetaInfo.fabricarAssinatura(new Tipo(tp), Quantidade.fabricarQt(1, 1)));
	return l;
    }

    @Override
    public String toString() {
	return super.toString().substring(super.toString().indexOf('@') + 1) + " = " + paramEntrada.get(0).toString();
    }
    
    public Variavel<Tp> getVar(){
	return new Variavel<Tp>(s,tpVar);
    }
    
    public Supplier<Tp> getSup() {
	return s;
    }
    
    public boolean equals(Variavel<?> obj) {
        return getSup().equals(obj.getSup());
    }
    
    public boolean equals(AtribuicaoVariavel<?> obj) {
        return getSup().equals(obj.getSup());
    }

}
