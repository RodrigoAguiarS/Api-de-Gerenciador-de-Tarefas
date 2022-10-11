package com.rodrigo.br.gerenciador.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.br.gerenciador.modelo.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
    Page<Tarefa> findByResponsavelNome(String nomeResponsavel, Pageable paginacao);
}
