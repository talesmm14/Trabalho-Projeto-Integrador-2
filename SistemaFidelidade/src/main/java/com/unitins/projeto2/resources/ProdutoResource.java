package com.unitins.projeto2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unitins.projeto2.models.Produto;
import com.unitins.projeto2.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/fidelidade")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{idProduto}")
	public Produto listaProdutoUnico(@PathVariable(value = "idProduto") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	public Produto createProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	public void deleteProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto") 
	public Produto updateProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}