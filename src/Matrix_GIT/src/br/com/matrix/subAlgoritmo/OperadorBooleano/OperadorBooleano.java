package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.List;
import java.util.function.Predicate;

import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoExec;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

public abstract class OperadorBooleano implements SubAlgoritmo<Boolean> {
    
    protected List<SubAlgoritmo<?>> l;
    protected List<MetaInfoAssinatura> param;
    protected Boolean b = false;

    public OperadorBooleano(List<MetaInfoAssinatura> param) {
	this.param = param;
    }
    
    @Override
    public MetaInfoExec getMetaInfo() {
	return MetaInfo.fabricarExec(Tipo.TP_BOOLEANO, param);
    }

    @Override
    public void preparar(List<SubAlgoritmo<?>> l){
	
	l.removeIf(new Predicate<SubAlgoritmo<?>>() {
	    @Override
	    public boolean test(SubAlgoritmo<?> sa) {
		return !sa.isPreparado()||!sa.getMetaInfo().equals(Tipo.TP_BOOLEANO);
	    }
	});

	this.l = l;
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
