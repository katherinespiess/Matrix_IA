/**
 * 
 */
package br.com.matrix.banco.tabelas.interfaces;

import java.util.HashMap;
import java.util.List;

/**
 * @author LucasGabrielDaCosta
 *
 */
public interface IArmazenavel {

	/**
	 * 
	 * @return ITabela que contem o código identificador do objeto armazenável.
	 */
	public ITabela getTb();

	/**
	 * 
	 * @return A lista de armazenaveis dependentes, isso é, referenciados aqui.
	 */
	public List<IArmazenavel> getDependencias();

	/**
	 * 
	 * @return Código identificador do objeto armazenável.
	 */
	public int getId();

	/**
	 * 
	 * @return A lista de valores dos campos da classa que implementa
	 *         armazenavel.
	 */
	public HashMap<IColuna, Object> getValores();

	/**
	 * 
	 * @paramReq a
	 * @return metodo de comparação especifico para armazenavel
	 */
	public default boolean equals(IArmazenavel a) {
		if (this == a)
			return true;
		if (a == null)
			return false;
		if (getClass() != a.getClass())
			return false;
		if (this.getId() != a.getId())
			return false;
		return ((getTb() == null) ? (a.getTb() == null) : getTb().equals(a.getTb()) && (getId() == a.getId()));
	}

}
