package com.Atividade_final.Atividade.services;

import com.Atividade_final.Atividade.model.Cidade;
import com.Atividade_final.Atividade.model.Produto;
import com.Atividade_final.Atividade.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    @Autowired
    CidadeRepository CidadeRepo;
    // Operações CRUD padrão

    public Cidade InsereCidade (Cidade c) {
        return CidadeRepo.save(c);
    }
    public Cidade AlteraCidade (Cidade c) {
        if(CidadeRepo.findById(c.getIdCidade()) == null){
            return null;
        } else {
            return CidadeRepo.save(c);
        }
    }
    public Cidade ProcuraCidadePorID (int id) {
        return CidadeRepo.findById(id).orElse(null);
    }

    public boolean ExcluirCidade (Cidade c) {
        if (CidadeRepo.findById(c.getIdCidade()) == null){
            return false;
        } else {
            try {
                CidadeRepo.delete(c);
                return true;
            } catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
