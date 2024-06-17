package com.Atividade_final.Atividade.resource;

import com.Atividade_final.Atividade.model.Cidade;
import com.Atividade_final.Atividade.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {
    @Autowired
    CidadeService CidadeServ;

    @PostMapping
    public ResponseEntity<String> inserirCidade(@RequestBody Cidade c) {
        if(CidadeServ.InsereCidade(c)){
            HttpHeaders localInstancia = new HttpHeaders();
            localInstancia.add("location","/cidade/"+c.getIdCidade());
            return new ResponseEntity<>("Criação realizada.",localInstancia, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().body("Criação não realizada, um erro não permitiu criar o objeto.");
        }
    }

    @PutMapping
    public ResponseEntity<String> alterarCidade(@RequestBody Cidade c) {
        if(CidadeServ.AlteraCidade(c).equals(null)) {
        return ResponseEntity.badRequest().body("Alteração não realizada, cadastro não existe.");
        } else {
            HttpHeaders localInstancia = new HttpHeaders();
            localInstancia.add("location","/cidade/"+c.getIdCidade());
            return new ResponseEntity<>("Criação realizada.",localInstancia, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/{id}")
    public Cidade procurarCidadePorID(@PathVariable Integer id) {
        Cidade c =CidadeServ.ProcuraCidadePorID(id);
        return c;
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deletarCidadePorID(@PathVariable Integer id) {
        Cidade c = CidadeServ.ProcuraCidadePorID(id);
        if(c.getIdCidade() == null) {
            return ResponseEntity.badRequest().body("Exclusão não relazida, cadastro não existe.");
        } else {
            CidadeServ.ExcluirCidade(c);
            return ResponseEntity.ok().body("Exclusão realizada.");
        }
    }
}
