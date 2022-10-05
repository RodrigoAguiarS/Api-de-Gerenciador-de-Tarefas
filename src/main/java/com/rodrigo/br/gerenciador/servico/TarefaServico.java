package com.rodrigo.br.gerenciador.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rodrigo.br.gerenciador.modelo.Resposta;
import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.repository.TarefaRepository;

@Service
public class TarefaServico {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private Resposta resposta;

    //Método para listrar tarefas
    public Iterable<Tarefa> listar() {
        return tarefaRepository.findAll();
    }

    //Método para cadastrar tarefas
    public ResponseEntity<?> cadastrar(Tarefa tarefa){
        if (tarefa.getDescricao().equals("")) {
            resposta.setMensagem("A descrição da tarefa é obrigatório");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<Tarefa>(tarefaRepository.save(tarefa), HttpStatus.CREATED);
        }
    }  
}
