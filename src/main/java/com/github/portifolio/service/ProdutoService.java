package com.github.portifolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.portifolio.modelo.Produto;
import com.github.portifolio.modelo.Resposta;
import com.github.portifolio.repositorio.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private Resposta resposta;
	
	//Método para cadastrar ou alterar produto
	public ResponseEntity<?> cadastrarAlterar(Produto produto, String acao){
		if(produto.getNome().equals("")) {
			resposta.setMensagem("O nome do produto é obrigatório!");
			return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
		}else if(produto.getMarca().equals("")){
			resposta.setMensagem("A marca produto é obrigatória!");
			return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
		}else {
			if(acao.equals("cadastrar")) {
				return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.OK);
			}
			
		}
	}
	
	//Método para lista todos os produtos
	public Iterable<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	//Método para remover produtos
	public ResponseEntity<Resposta> remover(long codigo){
		produtoRepository.deleteById(codigo);		
		resposta.setMensagem("O produto foi removido com sucesso!");
		
		return new ResponseEntity<Resposta>(resposta, HttpStatus.OK);
		
	}

}
