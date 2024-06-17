package com.Atividade_final.Atividade.services;

import com.Atividade_final.Atividade.model.CabeçalhoDePedido;
import com.Atividade_final.Atividade.model.Produto;
import com.Atividade_final.Atividade.model.ProdutosDoPedido;
import com.Atividade_final.Atividade.repository.ProdutosPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutosPedidoService {
    @Autowired
    ProdutosPedidoRepository ProdRepo;
    // Operações CRUD padrão

    public ProdutosDoPedido InsereProdPedido (Produto prod, Integer qtd, CabeçalhoDePedido idPedido) {
        ProdutosDoPedido prodpedido = new ProdutosDoPedido();
        prodpedido.setProduto(prod);
        prodpedido.setIdCabPedido(idPedido);
        prodpedido.setQuantidadeProduto(qtd);
        return ProdRepo.save(prodpedido);
    }
    public ProdutosDoPedido AlteraProdPedido (ProdutosDoPedido prod) {
        if(ProdRepo.findById(prod.getIdProdPedido()) == null){
            return null;
        } else {
            return ProdRepo.save(prod);
        }
    }
    public ProdutosDoPedido ProcuraProdPedidoPorID (int id) {
        return ProdRepo.findById(id).orElse(null);
    }

    public boolean ExcluirProdPedido (ProdutosDoPedido prod) {
        if(ProdRepo.findById(prod.getIdProdPedido()) == null){
            return false;
        } else {
            try {
                ProdRepo.delete(prod);
                return true;
            } catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
