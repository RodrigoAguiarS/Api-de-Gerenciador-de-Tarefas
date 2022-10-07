package com.rodrigo.br.gerenciador.dto.form;


import com.rodrigo.br.gerenciador.modelo.Responsavel;
import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.repository.ResponsavelRepository;
import com.rodrigo.br.gerenciador.repository.TarefaRepository;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class TarefaForm {
 
    @NonNull 
    private String titulo;
    @NonNull 
    private String descricao;
    @NonNull 
    private String nomeDoresponsavel;

    public Tarefa converter(ResponsavelRepository repository) {
        Responsavel responsavel = repository.findByNome(nomeDoresponsavel);
        return new Tarefa(titulo, descricao, responsavel);
    }

    public Tarefa atualizar(Integer id, TarefaRepository tarefaRepository) {
        Tarefa tarefa = tarefaRepository.getOne(id);
        tarefa.setTitulo(this.titulo);
        tarefa.setDescricao(this.descricao);
        tarefa.setResponsavel(tarefa.getResponsavel());
        return tarefa;
    } 
}
