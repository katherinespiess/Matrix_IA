package br.com.matrix.matrix;

public class testeMe {

	public static void main(String[] args) {
		Sugestor em = new Sugestor(1, null);
		System.out.println(em.executar(null).get());
		System.out.println(em.getIeAtivo());
	}

}
