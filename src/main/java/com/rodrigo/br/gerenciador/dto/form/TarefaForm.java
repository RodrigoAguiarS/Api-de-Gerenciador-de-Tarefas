package com.rodrigo.br.gerenciador.dto.form;


import com.rodrigo.br.gerenciador.modelo.Responsavel;
import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.repository.ResponsavelRepository;
import com.rodrigo.br.gerenciador.repository.TarefaRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaForm {
 
    
    private String titulo;
    
    private String descricao;
   
    private String nomeDoResponsavel;

    public TarefaForm() {
    }

    public TarefaForm(String titulo, String descricao, String nomeDoResponsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public Tarefa converter(ResponsavelRepository repository) {
        Responsavel responsavel = repository.findByNome(nomeDoResponsavel);
        return new Tarefa(titulo, descricao, responsavel);
    }

    public Tarefa atualizar(Long id, TarefaRepository tarefaRepository) {
        Tarefa tarefa = tarefaRepository.getOne(id);
        tarefa.setTitulo(this.titulo);
        tarefa.setDescricao(this.descricao);
        tarefa.setResponsavel(tarefa.getResponsavel());
        return tarefa;
    } 
}
