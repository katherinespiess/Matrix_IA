package br.com.matrix.subAlgoritmo.OperadorBooleano;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.matrix.subAlgoritmo.SubAlgoritmo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoExec;
import br.com.matrix.subAlgoritmo.MetaInfo.TipoGenerico;

public abstract class OperadorBooleano implements SubAlgoritmo<Boolean, Boolean> {
    
    protected List<SubAlgoritmo<Boolean, ?>> l;
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
    public void preparar(List<SubAlgoritmo<Boolean, ?>> l){
	
	l.removeIf(new Predicate<SubAlgoritmo<Boolean, ?>>() {

	    @Override
	    public boolean test(SubAlgoritmo<Boolean, ?> arg0) {
		return !arg0.isPreparado();
	    }
	});
	
	this.l = new ArrayList<>(l.size());
	this.l.addAll(l);
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
