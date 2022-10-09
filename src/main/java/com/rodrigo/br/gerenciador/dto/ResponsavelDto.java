package com.rodrigo.br.gerenciador.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.rodrigo.br.gerenciador.modelo.Responsavel;


import lombok.Getter;

@Getter
public class ResponsavelDto {

    public ResponsavelDto(Responsavel responsavel) {
        this.id = responsavel.getId();
        this.nome = responsavel.getNome();
    }
    private Long id;

    private String nome;

    public static List<ResponsavelDto> converter(List<Responsavel> responsaveis){
        return responsaveis.stream().map(ResponsavelDto::new).collect(Collectors.toList());
    }
}
