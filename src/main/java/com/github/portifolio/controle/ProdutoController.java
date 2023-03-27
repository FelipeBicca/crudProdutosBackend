package com.github.portifolio.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.portifolio.modelo.Produto;
import com.github.portifolio.modelo.Resposta;
import com.github.portifolio.service.ProdutoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/")
	public String rota() {
		return "API de produtos funcionando!";
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody Produto produto){
		return produtoService.cadastrarAlterar(produto, "cadastrar");
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<?> alterar(@RequestBody Produto produto){
		return produtoService.cadastrarAlterar(produto, "alterar");
	}
	
	@GetMapping("/listar")
	public Iterable<Produto> listar(){
		return produtoService.listar();
		
	}
	
	@DeleteMapping("remover/{codigo}")
	public ResponseEntity<Resposta> remover(@PathVariable long codigo){
		return produtoService.remover(codigo);
	}

}
