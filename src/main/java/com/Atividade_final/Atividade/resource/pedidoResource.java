package com.Atividade_final.Atividade.resource;

import com.Atividade_final.Atividade.model.CabeçalhoDePedido;
import com.Atividade_final.Atividade.services.CabeçalhoPedidoService;
import com.Atividade_final.Atividade.services.ProdutoService;
import com.Atividade_final.Atividade.services.ProdutosPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class pedidoResource {
    @Autowired
    CabeçalhoPedidoService CabServ;
    @Autowired
    ProdutosPedidoService ProdServ;
    @Autowired
    ProdutoService ProdutoServ;
    public static class PedidoRequest {
        private CabeçalhoDePedido cabecalho;
        private List<Integer> produtoIds;
        private List<Integer> produtoQtds;

        // Getters e setters
        public CabeçalhoDePedido getCabecalho() {
            return cabecalho;
        }

        public void setCabecalho(CabeçalhoDePedido cabecalho) {
            this.cabecalho = cabecalho;
        }

        public List<Integer> getProdutoIds() {
            return produtoIds;
        }

        public void setProdutoIds(List<Integer> produtoIds) {
            this.produtoIds = produtoIds;
        }
        public List<Integer> getProdutoQtds() {
            return produtoQtds;
        }

        public void setProdutoQtds(List<Integer> produtoQtds) {
            this.produtoQtds = produtoQtds;
        }
    }
    public ResponseEntity<String> criarPedido(@RequestBody PedidoRequest pedidoRequest) {
        try{
            CabServ.InsereCabPedido(pedidoRequest.getCabecalho());
            List<Integer> produtoIds = pedidoRequest.getProdutoIds();
            List<Integer> produtoQtds = pedidoRequest.getProdutoQtds();
            for(Integer item : produtoIds) {
                if(ProdutoServ.ProcuraProdutoPorID(item)==null) {
                    return ResponseEntity.badRequest().body("Criação não realizada, um erro não permitiu criar o objeto.");
                } else {
                    ProdServ.InsereProdPedido(ProdutoServ.ProcuraProdutoPorID(item),produtoQtds.get(produtoIds.indexOf(item)),pedidoRequest.getCabecalho());
                }
            }
            HttpHeaders localInstancia = new HttpHeaders();
            localInstancia.add("location","/pedido/"+pedidoRequest.getCabecalho().getIdCabPedido());
            return new ResponseEntity<>("Criação realizada.",localInstancia, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Criação não realizada, um erro não permitiu criar o objeto.");
        }
    }
}
