package br.com.matrix.subAlgoritmo.MetaInfo;

public interface Qt {
    public Integer getMin();
    public Integer getMax();
    
    public static Qt fabricarQt(Integer min, Integer max){
	return new Qt() {
	    
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
