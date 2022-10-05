package com.rodrigo.br.gerenciador.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.br.gerenciador.modelo.Responsavel;
import com.rodrigo.br.gerenciador.repository.ResponsavelRepository;

@Service
public class ResponsavelServico {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public Iterable<Responsavel> listar() {
        return responsavelRepository.findAll();
    }
}
