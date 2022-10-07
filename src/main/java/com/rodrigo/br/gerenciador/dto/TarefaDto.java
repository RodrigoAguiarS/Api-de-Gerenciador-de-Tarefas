package com.rodrigo.br.gerenciador.dto;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.rodrigo.br.gerenciador.modelo.Responsavel;
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

    private Responsavel responsavel;

    private LocalDateTime data = LocalDateTime.now();

    private String prioridade;

    private String situacao;

    public TarefaDto(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.responsavel = tarefa.getResponsavel();
        this.data = tarefa.getData();
        this.prioridade = tarefa.getPrioridade().name();
        this.situacao = tarefa.getSituacao().name();
    }

    public static List<TarefaDto> converter(List<Tarefa> tarefas){
        return tarefas.stream().map(TarefaDto::new).collect(Collectors.toList());
    }
}
