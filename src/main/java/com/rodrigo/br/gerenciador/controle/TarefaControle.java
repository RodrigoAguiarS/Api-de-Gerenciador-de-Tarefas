package com.rodrigo.br.gerenciador.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.servico.TarefaServico;

@RestController
public class TarefaControle {

    @Autowired
    private TarefaServico tarefaServico;


    @GetMapping("/tarefas")
    public Iterable<Tarefa> listar() {
        return tarefaServico.listar();
    }

    @PostMapping("/tarefas")
    public ResponseEntity<?> cadastrar(@RequestBody Tarefa tarefa) {
        return tarefaServico.cadastrar(tarefa);
    }
}
