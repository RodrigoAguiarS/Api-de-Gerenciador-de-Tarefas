package com.rodrigo.br.gerenciador.dto;


import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.rodrigo.br.gerenciador.modelo.Responsavel;
import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.repository.TarefaRepository;

import lombok.Getter;

@Getter
public class TarefaDto {

    public TarefaDto() {
        super();
    }
    private Long id;

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

    public static Page<TarefaDto> converter(Page<Tarefa> tarefas){
        return tarefas.map(TarefaDto::new);
    }

    public Tarefa atualizar(Long id, TarefaRepository tarefaRepository) {
        Tarefa tarefa = tarefaRepository.getOne(id);
        tarefa.setTitulo(this.titulo);
        tarefa.setDescricao(this.descricao);
        tarefa.setResponsavel(this.responsavel);
        return tarefa;
    } 
}
