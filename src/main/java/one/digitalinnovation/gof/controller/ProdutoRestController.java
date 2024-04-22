package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Produto;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author falvojr
 */
@RestController
@RequestMapping("produtos")
public class ProdutoRestController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<Iterable<Produto>> buscarTodos() {
		return ResponseEntity.ok(produtoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(produtoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
		produtoService.inserir(produto);
		return ResponseEntity.ok(produto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		produtoService.atualizar(id, produto);
		return ResponseEntity.ok(produto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
