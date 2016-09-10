package br.com.matrix.evo.suporte;

import java.util.function.Predicate;

/**
 * Condição fim, usado para determinar até quando continuará a executar,
 * reproduzir e eliminar a entidades EVO.
 * 
 * @param <F>
 *            - Tipagem da entrada da condição fim para rodar as entidades
 */
public abstract interface CondicaoFimEvo<F> extends Predicate<F> {
}
