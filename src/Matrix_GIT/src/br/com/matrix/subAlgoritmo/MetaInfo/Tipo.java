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
	final int prime = 31;
	int result = 1;
	result = prime * result + ((s == null) ? 0 : s.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	return hashCode() == obj.hashCode();
    }

    public static final Tipo TP_BOOLEANO = new Tipo(Boolean.class);
    public static final Tipo TP_INTEIRO = new Tipo(Integer.class);
}
