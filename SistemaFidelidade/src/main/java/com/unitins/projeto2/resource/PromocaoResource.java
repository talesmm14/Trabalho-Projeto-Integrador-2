package com.unitins.projeto2.resource;

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

import com.unitins.projeto2.models.Promocao;
import com.unitins.projeto2.repository.PromocaoRepository;

@RestController
@RequestMapping(value = "/fidelidade")
public class PromocaoResource {

	@Autowired
	PromocaoRepository promocaoRepository;

	@GetMapping("/promocaos")
	public List<Promocao> findAll() {
		return promocaoRepository.findAll();
	}

	@GetMapping("/promocao/{idPromocao}")
	public Promocao findById(@PathVariable(value = "idPromocao") long id) {
		return promocaoRepository.findById(id);
	}

	@PostMapping("/promocao")
	public Promocao createPromocao(@RequestBody Promocao promocao) {
		return promocaoRepository.save(promocao);
	}

	@DeleteMapping("/promocao")
	public void deletePromocao(@RequestBody Promocao promocao) {
		promocaoRepository.delete(promocao);
	}

	@PutMapping("/promocao")
	public Promocao updatePromocao(@RequestBody Promocao promocao) {
		return promocaoRepository.save(promocao);
	}

	@GetMapping("/promocao/{nomePromocao}")
	public Promocao findByCpf(@PathVariable(value = "nomePromocao") String nome) {
		return promocaoRepository.findByNome(nome);
	}

}
