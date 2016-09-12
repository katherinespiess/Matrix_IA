package br.com.matrix.subAlgoritmo.MetaInfo;

public class Tipo{

    private String s;
    
    public Tipo(String s){
	this.s = s;
    }
    
    public Tipo(Class<?> a){
	this.s = a.getSimpleName();
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
	return hashCode() == obj.hashCode();
    }

    public static final Tipo TP_BOOLEANO = new Tipo(Boolean.class.getSimpleName());
    public static final Tipo TP_INTEIRO = new Tipo(Integer.class.getSimpleName());
}
