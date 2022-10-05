package com.rodrigo.br.gerenciador.dto;


import java.time.LocalDateTime;

import com.rodrigo.br.gerenciador.modelo.Tarefa;

import lombok.Getter;

@Getter
public class TarefaDto {

    public TarefaDto() {
        super();
    }
    private int id;

    private String titulo;

    private String descricao;

    private int responsavel;

    private LocalDateTime data = LocalDateTime.now();

    private String prioridade;

    private String situacao;

    public TarefaDto(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.responsavel = tarefa.getResponsavel().getId();
        this.data = tarefa.getData();
        this.prioridade = tarefa.getPrioridade().name();
        this.situacao = tarefa.getSituacao().name();
    }
}
