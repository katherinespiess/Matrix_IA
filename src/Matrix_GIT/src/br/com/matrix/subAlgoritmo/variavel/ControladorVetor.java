package br.com.matrix.subAlgoritmo.variavel;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public class ControladorVetor<Tp> implements Supplier<Tp> {

    HashMap<String, Tp> hashMapTp;
    Tp tp;

    @Override
    public Tp get() {
	return tp;
    }

    public void prepararGet(List<Double> pos) {
	StringBuilder sb = new StringBuilder();

	for (Double d : pos) {
	    sb.append("." + d.toString());
	}

	tp = getHashMapTp().get(sb.toString());
    }

    public void prepararGet(Double pos) {
	tp = getHashMapTp().get("." + pos.toString());
    }

    public void set(Tp tp, Double pos) {
	this.getHashMapTp().put("." + pos.toString(), tp);
    }

    public void set(Tp tp, List<Double> pos) {
	StringBuilder sb = new StringBuilder();

	for (Double d : pos) {
	    sb.append("." + d.toString());
	}

	this.getHashMapTp().put(sb.toString(), tp);
    }

    private HashMap<String, Tp> getHashMapTp() {
	if (hashMapTp == null)
	    hashMapTp = new HashMap<>();
	return hashMapTp;
    }

}
