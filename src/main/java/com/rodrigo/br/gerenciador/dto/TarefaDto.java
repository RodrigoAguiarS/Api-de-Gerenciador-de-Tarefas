package com.rodrigo.br.gerenciador.dto;

import org.springframework.data.domain.Page;

import com.rodrigo.br.gerenciador.modelo.Tarefa;

import lombok.Getter;

@Getter
public class TarefaDto {

    public TarefaDto() {
        super();
    }
    private Long id;
    private String titulo;
    private String descricao;
    private String nomeResponsavel;


    public TarefaDto(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.nomeResponsavel = tarefa.getResponsavel().getNome();
    }

    public static Page<TarefaDto> converter(Page<Tarefa> tarefas){
        return tarefas.map(TarefaDto::new);
    }
}
