package com.rodrigo.br.gerenciador.controle;



import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.rodrigo.br.gerenciador.dto.ResponsavelDto;
import com.rodrigo.br.gerenciador.dto.form.ResponsavelForm;
import com.rodrigo.br.gerenciador.modelo.Responsavel;
import com.rodrigo.br.gerenciador.repository.ResponsavelRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/responsavel")
public class ResponsavelControle {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @GetMapping
    public List<ResponsavelDto> lista() {
        List<Responsavel> responsaveis = responsavelRepository.findAll();
        return ResponsavelDto.converter(responsaveis);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponsavelDto> cadastar(@Validated @RequestBody ResponsavelForm form, UriComponentsBuilder uriBuilder) {
        Responsavel responsavel = form.converter(form);
        responsavelRepository.save(responsavel);

        URI uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(responsavel.getId()).toUri();
        return ResponseEntity.created(uri).body(new ResponsavelDto(responsavel));
    }
}
