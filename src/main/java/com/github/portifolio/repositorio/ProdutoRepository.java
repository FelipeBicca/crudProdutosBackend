package com.github.portifolio.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.portifolio.modelo.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
