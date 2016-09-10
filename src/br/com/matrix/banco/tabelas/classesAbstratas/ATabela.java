package br.com.matrix.banco.tabelas.classesAbstratas;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.banco.tabelas.interfaces.ITabela;
import br.com.matrix.banco.tabelas.propTabelas.Coluna;
import br.com.matrix.banco.tabelas.propTabelas.ColunaFk;

public abstract class ATabela implements ITabela {

	/**
	 * - Lista de depêndencias no banco de dados
	 */
	protected List<ColunaFk> dependencias;

	/**
	 * - Lista de colunas na tabela do banco de dados
	 */
	protected List<Coluna> colunas;
	
	/**
	 * - Nome da tabela do banco de dados
	 */
	protected String nm;

	/**
	 * - Apelido da tabela do banco de dados que sera usado nos codigos de sql
	 */
	protected String ap;

	/**
	 * @return uma lista das dependencias com pk,fk,e referencia de ambas as tabelas do banco
	 */
	@Override
	public List<ColunaFk> getDependecias() {
		return (this.dependencias == null) ? this.dependencias = new ArrayList<>() : this.dependencias;
	}

	/**
	 * @return uma lista das colunas da tabela do banco
	 */
	@Override
	public List<Coluna> getColunas() {
		if (this.colunas == null)
			this.colunas = new ArrayList<>();
		return this.colunas;
	}

	@Override
	public String getNm() {
		return this.nm;
	}

	@Override
	public String getApelido() {
		return ap;
	}

	/**
	 * 
	 * @return instância da tabela em questão
	 */
	public static ATabela get() {
		return null;
	}

	/**
	 * 
	 * @param nm
	 * @param ap
	 */
	protected ATabela(String nm,String ap) {

		this.nm = nm;
		this.ap = ap;

	}
	
	public Coluna getId(){
		for (Coluna coluna : getColunas()) {
			if (coluna.getNm().equalsIgnoreCase("id"))
				return coluna;
		}
		return null;
	}

}
