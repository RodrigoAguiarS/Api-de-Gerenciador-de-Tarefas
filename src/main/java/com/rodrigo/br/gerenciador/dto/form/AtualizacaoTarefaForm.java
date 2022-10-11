package com.rodrigo.br.gerenciador.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.repository.TarefaRepository;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AtualizacaoTarefaForm {

    @NotEmpty @NotNull
    private String titulo;
    
    @NotEmpty @NotNull
    private String descricao;
   
    public Tarefa atualizar(Long id, TarefaRepository tarefaRepository) {

        Tarefa tarefa = tarefaRepository.getOne(id);
        tarefa.setTitulo(this.titulo);
        tarefa.setDescricao(this.descricao);

        return tarefa;
    }
}
