package com.rodrigo.br.gerenciador.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.br.gerenciador.modelo.Responsavel;
import com.rodrigo.br.gerenciador.servico.ResponsavelServico;

@RestController
public class ReponsavelControle {

    @Autowired
    private ResponsavelServico responsavelServico;

    @GetMapping("/responsavel")
    public Iterable<Responsavel> listar() {
        return responsavelServico.listar();
    }

    @GetMapping("/")
    public String rota() {
        return "Api de responsavel funcionando";

    }
}
