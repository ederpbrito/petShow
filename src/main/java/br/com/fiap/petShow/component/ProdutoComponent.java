package br.com.fiap.petShow.component;

import br.com.fiap.petShow.model.Produto;
import br.com.fiap.petShow.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoComponent {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorCodigo(String codigo){
        Produto produto = produtoRepository.findByCodigo(codigo);
        if(produto == null){
            throw new RuntimeException("Produto Inexistente!");
        }
        return produto;
    }

    public Produto buscarPorNome(String nome){

        Produto produto = produtoRepository.findByNome(nome);

        if(produto == null){
            throw new RuntimeException("Produto não encontrado!");
        }else{
            return produto;
        }
    }

    public void save(Produto produto){
        Produto prod = produtoRepository.findByCodigo(produto.getCodigo());

        if(prod != null){
            produto.setId(prod.getId());
        }

        produtoRepository.save(produto);
    }

    public void apagarProduto(String codigo){
        Produto produto = produtoRepository.findByCodigo(codigo);

        if(produto != null){
            produtoRepository.delete(produto);
        }
    }

    public void apagarTodos(){
        produtoRepository.deleteAll();
    }
}
