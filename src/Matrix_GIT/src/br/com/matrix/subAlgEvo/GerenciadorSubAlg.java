package br.com.matrix.subAlgEvo;

import br.com.matrix.evo.GerenciadorEvo;
import br.com.matrix.evo.suporte.GrupoEntidadesEvo;
import br.com.matrix.subAlgoritmo.SubAlgoritmo;

public abstract class GerenciadorSubAlg<R, P, F> implements GerenciadorEvo<SubAlgoritmo<?>, R, P, F>{

    GrupoEntidadesEvo<SubAlgoritmo<?>, R, P> lE;

    @Override
    public GrupoEntidadesEvo<SubAlgoritmo<?>, R, P> getLE() {
	return lE != null? lE : (lE = new GrupoEntidadesEvo<>());
    }

}
