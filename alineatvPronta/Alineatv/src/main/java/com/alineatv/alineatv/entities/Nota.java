package com.alineatv.alineatv.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_nota;



    private String nome_disciplina;
    private Double nota;
  
    public Nota(){
        
    }

    public Nota(Integer id_nota, String nome_disciplina, Double nota) {
        this.id_nota = id_nota;
        this.nome_disciplina = nome_disciplina;
        this.nota = nota;
    }

    public String getNome_disciplina() {
        return nome_disciplina;
    }
    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getId_nota() {
        return id_nota;
    }

}
