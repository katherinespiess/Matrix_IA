package br.com.matrix.matrix;

import java.util.ArrayList;

import br.com.matrix.banco.Database;
import br.com.matrix.banco.tabelas.Estruturas;
import br.com.matrix.banco.tabelas.propTabelas.Linha;

public class testeMe {

	public static void main(String[] args) {
		String cmd = Database.selectBuilder(Estruturas.get().getColunas().subList(1, 2));
		System.out.println("\n" + cmd + "\n");
		ArrayList<Linha> result = Database.execute(cmd);
		for (Linha linha : result) {
			System.out.println(linha);
		}
	}

}
