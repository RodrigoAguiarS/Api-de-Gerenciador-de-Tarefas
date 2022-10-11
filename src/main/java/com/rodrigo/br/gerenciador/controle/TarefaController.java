package com.rodrigo.br.gerenciador.controle;


import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodrigo.br.gerenciador.dto.DetalhesTarefaDto;
import com.rodrigo.br.gerenciador.dto.TarefaDto;
import com.rodrigo.br.gerenciador.dto.form.AtualizacaoTarefaForm;
import com.rodrigo.br.gerenciador.dto.form.TarefaForm;
import com.rodrigo.br.gerenciador.modelo.Tarefa;
import com.rodrigo.br.gerenciador.repository.ResponsavelRepository;
import com.rodrigo.br.gerenciador.repository.TarefaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired 
    private ResponsavelRepository responsavelRepository;

    //Método de Listar todas as tarefas
    @GetMapping
    @Cacheable(value = "listaDeTarefas")
    public Page<TarefaDto> lista(@RequestParam(required = false) String nomeDoResponsavel,
    @PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

        if (nomeDoResponsavel == null){
            Page<Tarefa> tarefas = tarefaRepository.findAll(paginacao);
            return TarefaDto.converter(tarefas);
        } else {
            Page<Tarefa> tarefas = tarefaRepository.findByResponsavelNome(nomeDoResponsavel, paginacao);
            return TarefaDto.converter(tarefas);
        }
    }

    //Método para detalhar atividades por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTarefaDto> detalhar(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isPresent()) {
            return ResponseEntity.ok(new DetalhesTarefaDto(tarefa.get()));
        }
        return ResponseEntity.notFound().build();
    }

    //Método de cadastrar tarefa
    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeTarefas", allEntries = true)
    public ResponseEntity<TarefaDto> cadastrar(@RequestBody @Valid TarefaForm form , UriComponentsBuilder uriBuilder) {
        Tarefa tarefa = form.converter(responsavelRepository);
        tarefaRepository.save(tarefa);

        URI uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();
        return ResponseEntity.created(uri).body(new TarefaDto(tarefa));
    }

    //Método para atualizar tarefas
    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTarefas", allEntries = true)
    public ResponseEntity<TarefaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTarefaForm form) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        if (optional.isPresent()) {
            Tarefa tarefa = form.atualizar(id, tarefaRepository);
            return ResponseEntity.ok(new TarefaDto(tarefa));
        }
        return ResponseEntity.notFound().build();
    }

    //Método para Remover/deletar tarefas
    @DeleteMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    @CacheEvict(value = "listaDeTarefas", allEntries = true)
    public ResponseEntity<TarefaDto> remover(@PathVariable Long id) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        if (optional.isPresent()) {
            tarefaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
