package com.alineatv.alineatv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alineatv.alineatv.entities.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {

    
} 
