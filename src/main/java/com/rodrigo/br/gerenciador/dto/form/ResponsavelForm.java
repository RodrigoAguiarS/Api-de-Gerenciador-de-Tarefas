package com.rodrigo.br.gerenciador.dto.form;



import com.rodrigo.br.gerenciador.modelo.Responsavel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelForm {

    private int id;
    private String nome;

    public ResponsavelForm(){}

    public ResponsavelForm(Responsavel responsavel) {
        this.id = responsavel.getId();
        this.nome = responsavel.getNome();
    }

    public Responsavel converter(ResponsavelForm form) {
        return new Responsavel(id, nome);
    }
}
