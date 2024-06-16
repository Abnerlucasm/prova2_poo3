package com.Atividade_final.Atividade.repository;

import com.Atividade_final.Atividade.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
