package br.com.matrix.banco.tabelas.interfaces;

public interface ICampo {

	/**
	 * 
	 * @return a coluna a qual o campo pertence
	 */
	public IColuna getColuna();	
	
	/**
	 * 
	 * @return o valor podendo ser String, Integer, Date, Boolean ou Double
	 */
	public Object getValor();			
	
}
