package com.Atividade_final.Atividade.resource;

import com.Atividade_final.Atividade.model.Cidade;
import com.Atividade_final.Atividade.model.Cliente;
import com.Atividade_final.Atividade.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
    @Autowired
    ClienteService ClienteServ;

    @PostMapping
    public ResponseEntity<String> inserirCliente(@RequestBody Cliente c) {
        if(ClienteServ.InsereCliente(c)){
            HttpHeaders localInstancia = new HttpHeaders();
            localInstancia.add("location","/cliente/"+c.getIdCliente());
            return new ResponseEntity<>("Criação realizada.",localInstancia, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().body("Criação não realizada, um erro não permitiu criar o objeto.");
        }
    }

    @PutMapping
    public ResponseEntity<String> alterarCliente(@RequestBody Cliente c) {
        if(ClienteServ.AlteraCliente(c).equals(null)) {
            return ResponseEntity.badRequest().body("Alteração não realizada, cadastro não existe.");
        } else {
            HttpHeaders localInstancia = new HttpHeaders();
            localInstancia.add("location","/cidade/"+c.getIdCliente());
            return new ResponseEntity<>("Criação realizada.",localInstancia, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/{id}")
    public Cliente procurarClientePorID(@PathVariable Integer id) {
        Cliente c =ClienteServ.ProcuraClientePorID(id);
        return c;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarClientePorID(@PathVariable Integer id) {
        Cliente c = ClienteServ.ProcuraClientePorID(id);
        if(c.getIdCliente() == null) {
            return ResponseEntity.badRequest().body("Exclusão não relazida, cadastro não existe.");
        } else {
            ClienteServ.ExcluirCliente(c);
            return ResponseEntity.ok().body("Exclusão realizada.");
        }
    }
}
