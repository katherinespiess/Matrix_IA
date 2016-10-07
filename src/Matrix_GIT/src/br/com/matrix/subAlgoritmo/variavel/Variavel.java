package br.com.matrix.subAlgoritmo.variavel;

import br.com.matrix.subAlgoritmo.Entrada;

public class Variavel<Tp> extends Entrada<Tp> {

    public Variavel(ControladorVariavel<Tp> s, Class<Tp> tp) {
	super(s, tp);
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString()+" from Var";
    }
    
    public AtribuicaoVariavel<Tp> getAtVar() {
	return new AtribuicaoVariavel<Tp>((ControladorVariavel<Tp>) s, this.tpResult);
    }
    
    public boolean equals(Variavel<?> obj) {
        return getSup().equals(obj.getSup());
    }
    
    public boolean equals(AtribuicaoVariavel<?> obj) {
        return getSup().equals(obj.getSup());
    }

}
