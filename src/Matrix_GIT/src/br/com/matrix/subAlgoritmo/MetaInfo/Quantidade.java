package br.com.matrix.subAlgoritmo.MetaInfo;

/**
 * Encapsulador de quantidade, define um alcance com um minimo e um máximo
 * 
 * @author GustavoHenrique
 *
 */
public interface Quantidade {
    
    /**
     * 
     * @return a quantidade mínima definida nessa instância.
     */
    public Integer getMin();
    
    /**
     * 
     * @return a quantidade máxima definida nessa instância.
     */
    public Integer getMax();
    
    /**
     *  
     * @param min a quantidade mínima definida na nova instância.
     * @param max a quantidade máxima definida na nova instância.
     * @return uma nova instância de quantidade.
     */
    public static Quantidade fabricarQt(Integer min, Integer max){
	return new Quantidade() {
	    
	    @Override
	    public Integer getMin() {
		return min;
	    }
	    
	    @Override
	    public Integer getMax() {
		return max;
	    }
	};
    }
}
