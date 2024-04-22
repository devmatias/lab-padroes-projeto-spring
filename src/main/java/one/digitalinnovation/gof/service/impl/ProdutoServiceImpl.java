package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.*;
import one.digitalinnovation.gof.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ProdutoService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ProdutoServiceImpl implements ProdutoService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ProdutoRepository produtoRepository;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Produto> buscarTodos() {
		// Buscar todos os Produtos.
		return produtoRepository.findAll();
	}

	@Override
	public Produto buscarPorId(Long id) {
		// Buscar Produto por ID.
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}

	@Override
	public void inserir(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public void atualizar(Long id, Produto produto) {
		// Buscar Produto por ID, caso exista:
		Produto produtoBd = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id));
		produtoBd.setPreco(produto.getPreco());
		produtoBd.setNome(produto.getNome());
		produtoRepository.save(produtoBd);

	}

	@Override
	public void deletar(Long id) {
		// Deletar Produto por ID.
		produtoRepository.deleteById(id);
	}

}
