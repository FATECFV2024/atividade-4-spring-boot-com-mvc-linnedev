package com.alineatv.alineatv.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


import com.alineatv.alineatv.services.NotaService;
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

import com.alineatv.alineatv.entities.Nota;

@RestController
@RequestMapping(value = "/notas")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @GetMapping
    public ResponseEntity<List<Nota>> findAll(){
        List<Nota> list = notaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Nota> findById(@PathVariable Integer id){
        Nota obj = notaService.findbyId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/cadastrar-nota")
    public ResponseEntity<Nota> create(@RequestBody Nota nota) throws URISyntaxException{
        Nota createdNota = notaService.createNota(nota);
        return ResponseEntity.created(new URI("/notas/" + createdNota.getId_nota())).body(createdNota);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Nota> update(@PathVariable Integer id, @RequestBody Nota nota) {
        Nota updatedNota = notaService.uptadeNota(id, nota);
        return ResponseEntity.ok().body(updatedNota);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        notaService.deleteNota(id);
        return ResponseEntity.noContent().build();
    }
}

