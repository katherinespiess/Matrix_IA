package br.com.matrix.banco;

import java.util.ArrayList;

import br.com.matrix.banco.tabelas.Estruturas;
import br.com.matrix.banco.tabelas.Palavras;
import br.com.matrix.banco.tabelas.Sugestores;
import br.com.matrix.banco.tabelas.Sugestores_has_Estruturas;
import br.com.matrix.banco.tabelas.propTabelas.GenColuna;
public class Teste {

	public static void main(String[] args) {
		
//		ArrayList<ATabela> t = new ArrayList<ATabela>();
//		Datas d = Datas.get();
//		//Estruturas e = Estruturas.get();
//		t.add(d);
//		//t.add(e);
		ArrayList<GenColuna> c = new ArrayList<GenColuna>();
		c.addAll(Sugestores.get().getColunas());
		c.addAll(Sugestores_has_Estruturas.get().getColunas());
		c.addAll(Estruturas.get().getColunas());
		c.addAll(Palavras.get().getColunas());
		System.out.println(Database.selectBuilder(c));
		
	}

}
