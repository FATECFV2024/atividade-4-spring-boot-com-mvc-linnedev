package com.alineatv.alineatv.services;

import java.util.List;
import java.util.Optional;


import com.alineatv.alineatv.entities.Endereco;
import com.alineatv.alineatv.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }

    public Endereco findById(Integer id){
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException("O Endereco não foi encontrado"));
    }

    public Endereco createEndereco(Endereco endereco){
        return enderecoRepository.save(endereco); 
    }

    public Endereco updateEndereco(Integer id, Endereco endereco){
        Endereco obj = findById(id);
        obj.setRua(endereco.getRua());
        obj.setCidade(endereco.getCidade());
        obj.setEstado(endereco.getEstado());
        obj.setCep(endereco.getCep());
        obj.setNumero(endereco.getNumero());
        return enderecoRepository.save(obj);
    }

    public void deleteEndereco(Integer id){
        Endereco obj = findById(id);
        enderecoRepository.delete(obj);
    }


}