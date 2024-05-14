package com.alineatv.alineatv.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


import com.alineatv.alineatv.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alineatv.alineatv.entities.Aluno;

@RestController

@RequestMapping(value = "/alunos")

public class AlunoController {
    @Autowired
    private AlunoService alunoService;


    @GetMapping
    public ResponseEntity<List<Aluno>>findAll(){
        List <Aluno> list = alunoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno>findById(@PathVariable Long id){ 
        Aluno obj = alunoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/cadastrar-Aluno")
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) throws URISyntaxException{
        Aluno createdAluno = alunoService.createAluno(aluno);
        return ResponseEntity.created(new URI("/Alunos/" + createdAluno.getId())).body(createdAluno);
    }

    @PutMapping(value = "atualizar/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno Aluno) {
        Aluno updatedAluno = alunoService.updateAluno(id, Aluno);
        return ResponseEntity.ok().body(updatedAluno);
    }

    @DeleteMapping(value = "deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }


}
