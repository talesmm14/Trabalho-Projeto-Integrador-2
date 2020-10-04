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

import com.unitins.projeto2.models.Cliente;
import com.unitins.projeto2.models.Funcionario;
import com.unitins.projeto2.models.HistoricoTroca;
import com.unitins.projeto2.models.Produto;
import com.unitins.projeto2.repository.ClienteRepository;
import com.unitins.projeto2.repository.FuncionarioRepository;
import com.unitins.projeto2.repository.HistoricoRepository;
import com.unitins.projeto2.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/fidelidade")
public class FuncionarioResource {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	@Autowired
	HistoricoRepository historicoRepository; 
	@Autowired
	ClienteResource clienteResource;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ProdutoResource produtoResource;
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/funcionarios")
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/funcionario/{idFuncionario}")
	public Funcionario findById(@PathVariable(value = "idFuncionario") long id ) {
		return funcionarioRepository.findById(id);
	}
	
	@PostMapping("/funcionario")
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@DeleteMapping("/funcionario")
	public void deleteFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepository.delete(funcionario);
	}
	
	@PutMapping("/funcionario")
	public Funcionario updateFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@GetMapping("/troca/{cpfCliente}/{idProduto}")
	public String trocarPontos(@PathVariable(value = "cpfCliente") String cpf, @PathVariable(value = "idProduto") long idProduto ) {
		Cliente cliente = clienteRepository.findByCpf(cpf);
		Produto produto = produtoRepository.findById(idProduto);
		if(realizarTroca(cliente, produto)){
			return "Troca Realizada!!";
		}
		return "Troca não Realizada!!";
	}

	private boolean realizarTroca(Cliente cliente, Produto produto){
		if(cliente.getPontos() >= produto.getPontosRetirada()){
			HistoricoTroca troca = new HistoricoTroca(cliente, produto);
			troca.setProduto(produtoResource.findById(produto.getIdProduto()));
			clienteResource.updateCliente(troca.getCliente());
			historicoRepository.save(troca);
			return true;
		}
		return false;
	}
	
	@PostMapping("/funcionario/troca")
	public void realizarTroca(@RequestBody HistoricoTroca troca) {
		troca.setProduto(produtoResource.findById(troca.getProduto().getIdProduto()));
		if (pontosSufucientes(troca)) {
			troca.setCliente(clienteResource.findByCpf(troca.getCliente().getCpf()));
			troca.setPontosClienteAnterior(troca.getCliente().getPontos());
			troca.setPontosOperacao(troca.getProduto().getPontosRetirada());
			troca.setCliente(retirarPontosTroca(troca));
			troca.setPontosClientePosterior(troca.getCliente().getPontos());
			clienteResource.updateCliente(troca.getCliente());
			historicoRepository.save(troca);
		}
	}
	
	public boolean pontosSufucientes(HistoricoTroca troca) {
		
		if (clienteResource.findById(troca.getCliente().getIdUsuario()).getPontos() >= troca.getProduto().getPontosRetirada()) {
			return true;
		}
		
		return false;
	}
	
	public Cliente retirarPontosTroca(HistoricoTroca troca) {
		troca.getCliente().setPontos(troca.getCliente().getPontos() - troca.getProduto().getPontosRetirada());
		
		return troca.getCliente();
	}
	
}
