package com.rodrigo.br.gerenciador.modelo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Resposta {

    public Resposta() {}

    private String mensagem;
}
