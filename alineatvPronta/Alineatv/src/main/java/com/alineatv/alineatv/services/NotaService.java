package com.alineatv.alineatv.services;

import java.util.List;
import java.util.Optional;

import com.alineatv.alineatv.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alineatv.alineatv.entities.Nota;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> findAll(){
        return notaRepository.findAll();
    }

    public Nota findbyId(Integer id){
        Optional<Nota> obj = notaRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException("A Nota não foi encontrada"));
    }

    public Nota createNota(Nota nota){
        return notaRepository.save(nota);
    }

    public Nota uptadeNota(Integer id, Nota nota){
        Nota obj = findbyId(id);
        obj.setNome_disciplina(nota.getNome_disciplina());
        obj.setNota(nota.getNota());
        return notaRepository.save(obj);
    }

    public void deleteNota(Integer id){
        Nota obj = findbyId(id);
        notaRepository.delete(obj);
    }

}
