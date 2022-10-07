package com.rodrigo.br.gerenciador.config.validacao;

import lombok.Getter;

@Getter
public class ErroDeFomularioDto {

    private String campo;
    private String erro;

    public ErroDeFomularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
