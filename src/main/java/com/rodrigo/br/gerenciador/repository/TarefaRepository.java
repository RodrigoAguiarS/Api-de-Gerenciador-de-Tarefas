package com.rodrigo.br.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.br.gerenciador.modelo.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
}
