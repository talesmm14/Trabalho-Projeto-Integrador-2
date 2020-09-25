package com.unitins.projeto2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.unitins.projeto2.models.Categoria;
import com.unitins.projeto2.models.Produto;
import com.unitins.projeto2.repository.CategoriaRepository;
import com.unitins.projeto2.repository.ProdutoRepository;

@Service
public class Dbinit implements CommandLineRunner {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		
		Categoria categoria1 = new Categoria("Tortas");
		listaCategoria.add(categoria1);
		Categoria categoria2 = new Categoria("Bolos");
		listaCategoria.add(categoria2);
		Categoria categoria3 = new Categoria("Doces");
		listaCategoria.add(categoria3);
			
		categoriaRepository.saveAll(listaCategoria);
		
		List<Produto> listaProduto = new ArrayList<Produto>();
		
		Produto produto1 = new Produto("Bolo de cenoura", categoria2, 10, 100);
		listaProduto.add(produto1);
		Produto produto2 = new Produto("Torta de Morango", categoria1, 12, 120);
		listaProduto.add(produto2);
		Produto produto3 = new Produto("Doce de leite 200g", categoria3, 8, 80);
		listaProduto.add(produto3);
		Produto produto4 = new Produto("Bolo de Fuba", categoria2, 5, 50);
		listaProduto.add(produto4);
		Produto produto5 = new Produto("Torta de Limão", categoria1, 11, 110);
		listaProduto.add(produto5);
		Produto produto6 = new Produto("Doce de Jiló", categoria3, 6, 60);
		listaProduto.add(produto6);
		
		produtoRepository.saveAll(listaProduto);
		
	}
	
}
