package com.rodrigo.br.gerenciador.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @NotNull @NotEmpty
    private String titulo;

    @NotNull @NotEmpty
    private String descricao;

    @NotNull 
    private Responsavel responsavel;


    public TarefaDto(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.responsavel = tarefa.getResponsavel();
    }

    public Tarefa atualizar(Long id, TarefaRepository tarefaRepository) {
        Tarefa tarefa = tarefaRepository.getOne(id);
        tarefa.setTitulo(this.titulo);
        tarefa.setDescricao(this.descricao);
        tarefa.setResponsavel(this.responsavel);
        return tarefa;
    } 
}
