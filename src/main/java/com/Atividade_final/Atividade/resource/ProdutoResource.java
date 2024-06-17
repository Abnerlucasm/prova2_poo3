package com.Atividade_final.Atividade.resource;

import com.Atividade_final.Atividade.model.Cidade;
import com.Atividade_final.Atividade.model.Produto;
import com.Atividade_final.Atividade.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
    @Autowired
    ProdutoService ProdutoServ;
    @PostMapping
    public ResponseEntity<String> inserirProduto(@RequestBody Produto p) {
        if(ProdutoServ.InsereProduto(p)){
            HttpHeaders localInstancia = new HttpHeaders();
            localInstancia.add("location","/produto/"+p.getId());
            return new ResponseEntity<>("Criação realizada.",localInstancia, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().body("Criação não realizada, um erro não permitiu criar o objeto.");
        }
    }

    @PutMapping
    public ResponseEntity<String> alterarProduto(@RequestBody Produto p) {
        if(ProdutoServ.AlteraProduto(p).equals(null)) {
            return ResponseEntity.badRequest().body("Alteração não realizada, cadastro não existe.");
        } else {
            HttpHeaders localInstancia = new HttpHeaders();
            localInstancia.add("location","/produto/"+p.getId());
            return new ResponseEntity<>("Criação realizada.",localInstancia, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/{id}")
    public Produto procurarProdutoPorID(@PathVariable Integer id) {
        Produto p =ProdutoServ.ProcuraProdutoPorID(id);
        return p;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCidadePorID(@PathVariable Integer id) {
        Produto p = ProdutoServ.ProcuraProdutoPorID(id);
        if(p.getId() == null) {
            return ResponseEntity.badRequest().body("Exclusão não relazida, cadastro não existe.");
        } else {
            ProdutoServ.ExcluirProduto(p);
            return ResponseEntity.ok().body("Exclusão realizada.");
        }
    }
}
