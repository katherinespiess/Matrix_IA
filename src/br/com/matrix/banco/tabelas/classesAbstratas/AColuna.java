package br.com.matrix.banco.tabelas.classesAbstratas;

import br.com.matrix.banco.tabelas.interfaces.IColuna;

public abstract class AColuna implements IColuna {

	/**
	 * Nome da tabela a qual a coluna pertence
	 */
	protected ATabela tb;

	/**
	 * Nome da coluna do banco de dados
	 */
	protected String nm;
	
	
//	private ArrayList<Campo> cam;

	
	
	@Override
	public ATabela getTb() {

		return this.tb;
	}

	
	@Override
	public String getNm() {

		return this.nm;
	}

//	public void setCam(ArrayList<Campo> campo){
//		
//		this.cam = campo;
//	}
//	
//	public ArrayList<Campo> getCam(){
//		
//		return this.cam;
//	}
	/**
	 * 
	 * @param nm
	 * @param tb
	 * Fabrica de colunas
	 */
	protected AColuna(String nm, ATabela tb) {
		
		this.nm = nm;
		this.tb = tb;
		
	}

}
