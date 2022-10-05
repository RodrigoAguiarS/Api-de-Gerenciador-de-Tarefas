package com.rodrigo.br.gerenciador.servico;

import java.util.List;
import java.util.Optional;

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

    //Método para listar tarefas
    /*public Iterable<Tarefa> listar() {
        return tarefaRepository.findAll();
    }*/

    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
        
    }

    //Método para cadastrar tarefas
    public ResponseEntity<?> cadastrarAlterar(Tarefa tarefa, String acao){
        //verifica se possui descrição
        if (tarefa.getDescricao().equals("")) {
            resposta.setMensagem("A descrição da tarefa é obrigatório");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);

        //verifica se possui titulo
        }else if (tarefa.getTitulo().equals("")) {
            resposta.setMensagem("A Título da tarefa é obrigatório");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);

        }else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<Tarefa>(tarefaRepository.save(tarefa), HttpStatus.CREATED);
            }else {
                return new ResponseEntity<Tarefa>(tarefaRepository.save(tarefa), HttpStatus.OK);
            }
        } 
    } 
    
    //Método para remover tarefas
    public ResponseEntity<Resposta> remover(int id) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        if (optional.isPresent()){
            tarefaRepository.deleteById(id);
            resposta.setMensagem("A tarefa foi removida com sucesso!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.OK);

        }else{
            resposta.setMensagem("Não existe tarefa cadastrada com esse id!");
            return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
        }
    }
}
