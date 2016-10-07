package br.com.matrix.subAlgoritmo;

import java.util.List;

import br.com.matrix.subAlgoritmo.MetaInfo.MetaInfoExec;

/**
 * Fração de algoritmo, tal como: <br>
 * <code>if(...){}</code><br>
 * <code>for(...){}</code><br>
 * <code>a = b;</code>
 * 
 * @author GustavoHenrique
 *
 * @param <Tp>
 *            - Tipagem do retorno
 */
public interface SubAlgoritmo<Tp extends Object> {

    /**
     * 
     * @return A MetaInfoExec, um emcapsulador de tipo de retorno, e parâmetros
     *         requeridos.
     */
    public MetaInfoExec getMetaInfo();

    /**
     * 
     * @param l
     *            - Lista de parâmtros.
     * @throws IllegalArgumentException
     *             - Se a lista de parâmetros passados não for condisente com os
     *             requeridos.
     */
    public void preparar(List<SubAlgoritmo<?>> l) throws IllegalArgumentException;

    /**
     * 
     * @return true se está preparado
     */
    public boolean isPreparado();

    /**
     * Prepara para retornar e/ou executa um comando específico.
     */
    public void executar();

    /**
     * 
     * @return true se foi executado pelo menos uma vez.
     */
    public boolean isExecutado();

    /**
     * 
     * @return O Retorno da opeção executada.
     */
    public Tp retornar();
    
    /**
     * 
     * @param sa - subAlgoritmo à se verificar se é chamado direta ou indiretamente por esse.
     * @return true se o algoritmo sa for chamado.
     */
    public boolean isChamado(SubAlgoritmo<?> sa);
    
    /**
     * Atribui false ao isExecutado.
     */
    public void resetExecutado();
}
