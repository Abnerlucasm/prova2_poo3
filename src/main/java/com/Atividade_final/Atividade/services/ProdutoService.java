package com.Atividade_final.Atividade.services;

import com.Atividade_final.Atividade.model.Produto;
import com.Atividade_final.Atividade.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository ProdutoRepo;
    // Operações CRUD padrão

    public boolean InsereProduto (Produto p) {
        try {
            ProdutoRepo.save(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Produto AlteraProduto (Produto p) {
        if(ProdutoRepo.findById(p.getId()) == null){
            return null;
        } else {
            return ProdutoRepo.save(p);
        }
    }
    public Produto ProcuraProdutoPorID (int id) {
        return ProdutoRepo.findById(id).orElse(null);
    }

    public boolean ExcluirProduto (Produto p) {
        if (ProdutoRepo.findById(p.getId()) == null){
            return false;
        } else {
            try {
                ProdutoRepo.delete(p);
                return true;
            } catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
