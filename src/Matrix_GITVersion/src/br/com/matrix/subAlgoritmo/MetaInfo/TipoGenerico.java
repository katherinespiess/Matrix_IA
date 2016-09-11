package br.com.matrix.subAlgoritmo.MetaInfo;

public class TipoGenerico implements Tipo {

    private String s;
    
    public TipoGenerico(String s){
	this.s = s;
    }
    
    @Override
    public String get() {
	return s;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((s == null) ? 0 : s.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	return Integer.compare(hashCode(), obj.hashCode()) == 0;
    }

    public static final TipoGenerico TP_BOOLEANO = new TipoGenerico("Boolean");
    public static final TipoGenerico TP_INTEIRO = new TipoGenerico("Integer");
}
