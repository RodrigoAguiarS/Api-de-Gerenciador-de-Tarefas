package com.rodrigo.br.gerenciador.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;

import com.rodrigo.br.gerenciador.modelo.Responsavel;


import lombok.Getter;

@Getter
public class ResponsavelDto {

    private Long id;

    private String nome;

    private LocalDateTime dataCadastro = LocalDateTime.now();

    public ResponsavelDto(Responsavel responsavel) {
        this.id = responsavel.getId();
        this.nome = responsavel.getNome();
        this.dataCadastro = responsavel.getDataCadastro();
    }

    public static List<ResponsavelDto> converter(List<Responsavel> responsaveis){
        return responsaveis.stream().map(ResponsavelDto::new).collect(Collectors.toList());
    }
}
