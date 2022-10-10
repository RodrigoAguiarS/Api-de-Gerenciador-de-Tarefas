package com.rodrigo.br.gerenciador.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

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

    public DetalhesTarefaDto(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.responsavel = tarefa.getResponsavel();
    }

    private Long id;

    private String titulo;

    private String descricao;
 
    private Responsavel responsavel;

    private LocalDateTime data = LocalDateTime.now();

    private Prioridade prioridade = Prioridade.Média;

    private Situacao situacao = Situacao.Criada;

    public static Page<DetalhesTarefaDto> converter(Page<Tarefa> tarefas){
        return tarefas.map(DetalhesTarefaDto::new);
    }
}
