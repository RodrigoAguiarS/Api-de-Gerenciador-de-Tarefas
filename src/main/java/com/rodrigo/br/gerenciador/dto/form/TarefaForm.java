package com.rodrigo.br.gerenciador.dto.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rodrigo.br.gerenciador.modelo.Responsavel;
import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.repository.ResponsavelRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaForm {
    
    @NotEmpty @NotNull
    private String titulo;
    
    @NotEmpty @NotNull
    private String descricao;
   
    @NotEmpty @NotNull
    private String nomeResponsavel;

    public Tarefa converter(ResponsavelRepository repository) {
        Responsavel responsavel = repository.findByNome(nomeResponsavel);
        return new Tarefa(titulo, descricao, responsavel);
    }
}
