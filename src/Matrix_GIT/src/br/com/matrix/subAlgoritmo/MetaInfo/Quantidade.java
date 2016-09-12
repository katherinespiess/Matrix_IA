package br.com.matrix.subAlgoritmo.MetaInfo;

public interface Quantidade {
    public Integer getMin();
    public Integer getMax();
    
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
