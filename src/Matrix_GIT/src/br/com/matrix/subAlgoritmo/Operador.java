package br.com.matrix.subAlgoritmo;

import java.util.List;

import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoExec;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

public abstract class Operador<Tp extends Object> implements SubAlgoritmo<Tp> {
    
    protected List<SubAlgoritmo<?>> paramEntrada;
    protected List<MetaInfoAssinatura> paramReq;
    protected Tp result;

    public Operador(List<MetaInfoAssinatura> param) {
	this.paramReq = param;
    }

    @Override
    public void preparar(List<SubAlgoritmo<?>> l){	
	
	if (!MetaInfoAssinatura.compararListaMetaInfoSubAlg(paramReq, l))
	    throw new IllegalArgumentException();

	this.paramEntrada = l;
    }

    @Override
    public Tp retornar() {
	return result;
    }

    @Override
    public boolean isPreparado() {	
	return MetaInfoAssinatura.compararListaMetaInfoSubAlg(paramReq, paramEntrada);
    }
    
    @Override
    public MetaInfoExec getMetaInfo() {
	return MetaInfo.fabricarExec(new Tipo(result.getClass()), paramReq);
    }

}
