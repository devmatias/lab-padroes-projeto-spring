package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Produto;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author falvojr
 */
public interface ProdutoService {

	Iterable<Produto> buscarTodos();

	Produto buscarPorId(Long id);

	void inserir(Produto produto);

	void atualizar(Long id, Produto produto);

	void deletar(Long id);

}
