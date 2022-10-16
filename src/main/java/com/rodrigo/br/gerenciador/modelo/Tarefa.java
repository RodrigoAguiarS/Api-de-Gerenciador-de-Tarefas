package com.rodrigo.br.gerenciador.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;

    private String descricao;

    @ManyToOne
    private Responsavel responsavel;


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime data = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade = Prioridade.Média;

    @Enumerated(EnumType.STRING)
    private Situacao situacao = Situacao.Criada;

    public Tarefa() {}

    public Tarefa(String titulo, String descricao, Responsavel responsavel) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
    }
}
