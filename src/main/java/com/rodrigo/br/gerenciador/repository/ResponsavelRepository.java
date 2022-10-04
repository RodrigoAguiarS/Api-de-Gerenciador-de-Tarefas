package com.rodrigo.br.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.br.gerenciador.modelo.Reponsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Reponsavel, Integer> {
    
}
