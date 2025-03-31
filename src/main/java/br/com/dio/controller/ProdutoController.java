package br.com.dio.controller;

import br.com.dio.entity.Produto;
import br.com.dio.exceptions.ProductNullException;
import br.com.dio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;
    //@RequestMapping(method = RequestMethod.GET, value = "/save")

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaProduto (@RequestBody Produto produto) throws Exception {
        produto = service.save(produto);
        return ResponseEntity.ok().body(produto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscaProduto (@PathVariable long id){
        Produto produto = service.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<Produto>> buscaAllProdutos (){
        List <Produto> produtos = service.findAll();
        return ResponseEntity.ok().body(produtos);
    }

}

