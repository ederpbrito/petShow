package br.com.fiap.petShow.controller;

import br.com.fiap.petShow.component.ProdutoComponent;
import br.com.fiap.petShow.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "produto")
public class ProdutoController {

    @Autowired
    ProdutoComponent produtoComponent;

    @PostMapping
    public void salvar(@RequestBody Produto produto){
        produtoComponent.save(produto);
    }

    @GetMapping()
    public List<Produto> buscarTodos(){
        return produtoComponent.findAll();
    }

    @GetMapping("/codigo/{codigo}")
    public Produto buscarPorCodigo(@PathVariable(value = "codigo") String codigo){
        return produtoComponent.buscarPorCodigo(codigo);
    }

    @GetMapping("/nome/{nome}")
    public Produto buscarPorNome(@PathVariable(value = "nome") String nomeproduto){
        return produtoComponent.buscarPorNome(nomeproduto);
    }

    @DeleteMapping("/codigo/{codigo}")
    public void excluirPorCodigo(@PathVariable(value = "codigo") String codigo){
        produtoComponent.apagarProduto(codigo);
    }

    @DeleteMapping()
    public void excluirTodos(){
        produtoComponent.apagarTodos();
    }
}