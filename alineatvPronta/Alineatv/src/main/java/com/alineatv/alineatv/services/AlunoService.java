package com.alineatv.alineatv.services;

import java.util.List;
import java.util.Optional;

import com.alineatv.alineatv.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alineatv.alineatv.entities.Aluno;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;
   
   
   
    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }


    public Aluno findById(Long id){
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElseThrow(() -> new IllegalArgumentException("o Aluno não foi encontrado"));
    }

    public Aluno createAluno(Aluno aluno){
        return alunoRepository.save(aluno); 
    }

    public Aluno updateAluno(Long id, Aluno aluno){
        Aluno obj = findById(id);
        obj.setAluno(aluno.getAluno());
        obj.setCurso(aluno.getCurso());
        obj.setIdade(aluno.getIdade());
        obj.setMatriculado(aluno.getMatriculado());
        return alunoRepository.save(obj);
    }

    public void deleteAluno(Long id){
        Aluno obj = findById(id);
        alunoRepository.delete(obj);
    }


}
