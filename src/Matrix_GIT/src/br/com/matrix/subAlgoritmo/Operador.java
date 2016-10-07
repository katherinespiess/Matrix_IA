package br.com.matrix.subAlgoritmo;

import java.util.ArrayList;
import java.util.List;

import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfo;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoAssinatura;
import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoExec;
import br.com.matrix.subAlgoritmo.MetaInfo.Tipo;

/**
 * Implementação abstrata de um operador de retorno Tp. <br>
 * Aplica-se à condições logicas, operações matemáticas, etc...
 * 
 * @author GustavoHenrique
 *
 * @param <Tp>
 *            - Tipagem do retorno
 */
public abstract class Operador<Tp extends Object> implements SubAlgoritmo<Tp> {
    /**
     * Parâmetros recebidos no preparo da execução;
     */
    protected List<SubAlgoritmo<?>> paramEntrada;

    /**
     * Parâmetros requeridos, definidos nas classes que extendem essa ou na
     * construção de uma instância.
     */
    protected List<MetaInfoAssinatura> paramReq;

    /**
     * Variável de controle para o resultado.
     */
    protected Tp result = null;

    /**
     * Variável de controle para tipagem do retorno
     */
    protected Class<Tp> tpResult;

    /**
     * Contrutor
     * 
     * @param param
     *            - Lista de parâmetro requeridos.
     * @param tp
     *            - Tipagem do retorno.
     */
    public Operador(List<MetaInfoAssinatura> param, Class<Tp> tp) {
	this.paramReq = param;
	this.tpResult = tp;
    }

    /**
     * Verificação de se os parâmetros estão de aconrto com o que foi requerido
     * <br>
     * e de se estão todos devidamente preparados.
     */
    @Override
    public void preparar(List<SubAlgoritmo<?>> l) {

	if (!MetaInfoAssinatura.compararListaMetaInfoSubAlg(paramReq, l))
	    throw new IllegalArgumentException("Faltam parâmetros");

	for (SubAlgoritmo<?> sa : l)
	    if (!sa.isPreparado())
		throw new IllegalArgumentException(sa.toString() + " - SubAlgoritmo não preparado.");

	this.paramEntrada = new ArrayList<>();
	paramEntrada.addAll(l);
    }

    /**
     * Retorna a variável de controle <code>result</code>
     */
    @Override
    public Tp retornar() {
	return result;
    }

    /**
     * Verifica se os parâmetros estão de acordo com o que foi solicitado.
     */
    @Override
    public boolean isPreparado() {
	return paramEntrada != null && !paramEntrada.isEmpty()
		&& MetaInfoAssinatura.compararListaMetaInfoSubAlg(paramReq, paramEntrada);
    }

    /**
     * Construção e retorno da meta info com base nas variáveis de controle
     * <code>tpResult</code> e <code>paramReq</code>.
     */
    @Override
    public MetaInfoExec getMetaInfo() {
	return MetaInfo.fabricarExec(new Tipo(tpResult), paramReq);
    }

    /**
     * Verifica se a variável de controle referente ao resultado é não nula.
     */
    @Override
    public boolean isExecutado() {
	return result != null;
    }

    @Override
    public boolean isChamado(SubAlgoritmo<?> sa) {
	boolean r = false;

	for (SubAlgoritmo<?> saLocal : paramEntrada) {
	    if (saLocal.equals(sa) || saLocal.isChamado(sa)) {
		r = true;
		break;
	    }
	}

	return r;
    }

    @Override
    public void resetExecutado() {
	result = null;
	
    }

}
