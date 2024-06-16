package com.Atividade_final.Atividade.services;

import com.Atividade_final.Atividade.model.Cliente;
import com.Atividade_final.Atividade.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository ClienteRepo;
    // Operações CRUD padrão
    public Cliente InsereCliente (Cliente c) {
        return ClienteRepo.save(c);
    }

    public Cliente AlteraCliente (Cliente c) {
        if (ClienteRepo.findById(c.getIdCliente()) == null) {
            return null;
        } else {
            return ClienteRepo.save(c);
        }
    }

    public Cliente ProcuraClientePorID (int id) {
        return ClienteRepo.findById(id).orElse(null);
    }

    public boolean ExcluirCliente (Cliente c) {
        if(ClienteRepo.findById(c.getIdCliente()) == null) {
            return false;
        } else {
            try {
                ClienteRepo.delete(c);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

}
