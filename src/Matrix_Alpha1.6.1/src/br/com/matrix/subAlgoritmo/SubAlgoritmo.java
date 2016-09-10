package br.com.matrix.subAlgoritmo;

import java.util.List;

import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoExec;

public interface SubAlgoritmo<R extends Object, P> {
    public MetaInfoExec getMetaInfo();
    public void preparar(List<SubAlgoritmo<P, ?>> l);
    public boolean isPreparado();
    public void executar();
    public R retornar();
}
