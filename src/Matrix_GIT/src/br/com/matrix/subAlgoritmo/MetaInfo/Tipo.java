package br.com.matrix.subAlgoritmo.MetaInfo;

/**
 * 
 * Encapsulador de tipagem
 * 
 * @author GustavoHenrique
 *
 */
public class Tipo{

    private String s;
    
    public Tipo(Class<?> a){
	this.s = a.getSimpleName();
    }
    
    public String getSimpleName(){
	return s;
    }

    @Override
    public int hashCode() {
	return ((s == null) ? 0 : s.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
	return hashCode() == obj.hashCode();
    }

    public static final Tipo TP_BOOLEANO = new Tipo(Boolean.class);
    public static final Tipo TP_NUMERICO = new Tipo(Double.class);
    public static final Tipo TP_VOID = new Tipo(Void.class);
}
