package br.com.matrix.aplicacao;

import java.util.ArrayList;
import java.util.List;

public class KeyVal {
	private Integer key;

	private List<Integer> val;

	public KeyVal(Integer k) {
		key = k;
		val = new ArrayList<>();
	}

	public int getKey() {
		return key;
	}

	public List<Integer> getVal() {
		return val;
	}
}
