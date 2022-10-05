package com.rodrigo.br.gerenciador.controle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.br.gerenciador.dto.TarefaDto;
import com.rodrigo.br.gerenciador.modelo.Resposta;
import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.servico.TarefaServico;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tarefas")
public class TarefaControle {

    @Autowired
    private TarefaServico tarefaServico;


    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> detalhar(@PathVariable int id) {
        return tarefaServico.detalhar(id);
    }

    @GetMapping
    public ResponseEntity<List<TarefaDto>> findAll() {
        List<Tarefa> list = tarefaServico.listar();
        List<TarefaDto> listDto = list.stream().map(obj -> new TarefaDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Tarefa tarefa) {
        return tarefaServico.cadastrarAlterar(tarefa, "Cadastrar");
    }

    @PutMapping
    public ResponseEntity<?> Alterar(@RequestBody Tarefa tarefa) {
        return tarefaServico.cadastrarAlterar(tarefa, "Alterar");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Resposta> remover(@PathVariable int id) {
        return tarefaServico.remover(id);
    }
}
