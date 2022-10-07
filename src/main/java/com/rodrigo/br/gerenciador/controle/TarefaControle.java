package com.rodrigo.br.gerenciador.controle;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodrigo.br.gerenciador.dto.TarefaDto;
import com.rodrigo.br.gerenciador.dto.form.TarefaForm;
import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.repository.ResponsavelRepository;
import com.rodrigo.br.gerenciador.repository.TarefaRepository;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tarefas")
public class TarefaControle {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @GetMapping
    public List<TarefaDto> lista() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return TarefaDto.converter(tarefas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TarefaDto> cadastar(@Validated @RequestBody TarefaForm form, UriComponentsBuilder uriBuilder) {
        Tarefa tarefa = form.converter(responsavelRepository);
        tarefaRepository.save(tarefa);

        URI uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();
        return ResponseEntity.created(uri).body(new TarefaDto(tarefa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> detalhar(@PathVariable Integer id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isPresent()) {
            return ResponseEntity.ok(new TarefaDto(tarefa.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TarefaDto> atualizar(@PathVariable Integer id, @RequestBody TarefaForm form) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        if (optional.isPresent()) {
            Tarefa tarefa = form.atualizar(id, tarefaRepository);
            return ResponseEntity.ok(new TarefaDto(tarefa));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<TarefaDto> remover(@PathVariable Integer id) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        if (optional.isPresent()) {
            tarefaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
