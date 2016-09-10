package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoExec;
import br.com.matrix.subAlgoritmo.MetaInfo.TipoGenerico;

public abstract class OperadorBooleano implements SubAlgoritmo<Boolean> {
    
    protected List<SubAlgoritmo<?>> l;
    protected List<MetaInfoAssinatura> param;
    protected Boolean b = false;

    public OperadorBooleano(List<MetaInfoAssinatura> param) {
	this.param = param;
    }
    
    @Override
    public MetaInfoExec getMetaInfo() {
	return MetaInfo.fabricarExec(TipoGenerico.TP_BOOLEANO, param);
    }

    @Override
    public void preparar(List<SubAlgoritmo<?>> l){
	
	l.removeIf(new Predicate<SubAlgoritmo<?>>() {

	    @Override
	    public boolean test(SubAlgoritmo<?> arg0) {
		return !arg0.isPreparado();
	    }
	});
	
	this.l = new ArrayList<>(l.size());
	
	l.forEach(new Consumer<SubAlgoritmo<?>>() {

	    @Override
	    public void accept(SubAlgoritmo<?> t) {
		if (t.getMetaInfo().getReturnTp().equals(TipoGenerico.TP_BOOLEANO))
		    OperadorBooleano.this.l.add(t);
	    }
	});
    }

    @Override
    public Boolean retornar() {
	return b;
    }

    @Override
    public boolean isPreparado() {	
	return l.containsAll(getMetaInfo().getParam());
    }

}
