package com.alineatv.alineatv.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


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

import com.alineatv.alineatv.entities.Endereco;
import com.alineatv.alineatv.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> list = enderecoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id){
        Endereco obj = enderecoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/cadastrar-endereco")
    public ResponseEntity<Endereco> create(@RequestBody Endereco endereco) throws URISyntaxException{
        Endereco createdEndereco = enderecoService.createEndereco(endereco);
        return ResponseEntity.created(new URI("/enderecos/" + createdEndereco.getCep())).body(createdEndereco);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Integer id, @RequestBody Endereco endereco) {
        Endereco updatedEndereco = enderecoService.updateEndereco(id, endereco);
        return ResponseEntity.ok().body(updatedEndereco);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
