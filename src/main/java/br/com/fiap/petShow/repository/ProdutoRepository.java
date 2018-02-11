package br.com.fiap.petShow.repository;

import br.com.fiap.petShow.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
       List<Produto> findAll();
       Produto findByNome(String nome);
       Produto findByCodigo(String codigo);
}
