package com.Atividade_final.Atividade.services;

import com.Atividade_final.Atividade.model.CabeçalhoDePedido;
import com.Atividade_final.Atividade.model.Cidade;
import com.Atividade_final.Atividade.repository.CabeçalhoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabeçalhoPedidoService {
    @Autowired
    CabeçalhoPedidoRepository CabRepo;
    // Operações CRUD padrão

    public CabeçalhoDePedido InsereCabPedido (CabeçalhoDePedido cab) {
        return CabRepo.save(cab);
    }
    public CabeçalhoDePedido AlteraCabPedido (CabeçalhoDePedido cab) {
        if(CabRepo.findById(cab.getIdCabPedido()) == null){
            return null;
        } else {
            return CabRepo.save(cab);
        }
    }
    public CabeçalhoDePedido ProcuraCabPedidoPorID (int id) {
        return CabRepo.findById(id).orElse(null);
    }

    public boolean ExcluirCabPedido (CabeçalhoDePedido cab) {
        if(CabRepo.findById(cab.getIdCabPedido()) == null){
            return false;
        } else {
            try {
                CabRepo.delete(cab);
                return true;
            } catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
