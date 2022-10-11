package com.rodrigo.br.gerenciador.dto;

import java.time.LocalDateTime;

import com.rodrigo.br.gerenciador.modelo.Prioridade;
import com.rodrigo.br.gerenciador.modelo.Responsavel;
import com.rodrigo.br.gerenciador.modelo.Situacao;
import com.rodrigo.br.gerenciador.modelo.Tarefa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalhesTarefaDto {

    public DetalhesTarefaDto(){
    }

    private Long id;

    private String titulo;

    private String descricao;
 
    private Responsavel responsavel;

    private LocalDateTime data = LocalDateTime.now();

    private Prioridade prioridade = Prioridade.Média;

    private Situacao situacao = Situacao.Criada;

    public DetalhesTarefaDto(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.responsavel = tarefa.getResponsavel();
        this.data = tarefa.getData();
        this.prioridade = tarefa.getPrioridade();
        this.situacao = tarefa.getSituacao();
    }
}
