package com.rodrigo.br.gerenciador.dto.form;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rodrigo.br.gerenciador.modelo.Responsavel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelForm {

    private Long id;
    
    @NotNull @NotEmpty
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
