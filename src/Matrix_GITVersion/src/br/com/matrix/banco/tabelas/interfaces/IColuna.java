package br.com.matrix.banco.tabelas.interfaces;

public interface IColuna {
	/**
	 * 
	 * @return a tabela a qual a coluna pertence.
	 */
    public ITabela getTb();
    		
    /**
     * 
     * @return nome da coluna
     */
    public String getNm();
}
