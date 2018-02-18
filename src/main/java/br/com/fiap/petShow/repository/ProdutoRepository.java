package br.com.fiap.petShow.repository;

import br.com.fiap.petShow.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
       List<Produto> findAll();
       @Query("{name : {$regex : ?0}}")
       Produto findByNome(String nome);
       Produto findByCodigo(String codigo);
}
