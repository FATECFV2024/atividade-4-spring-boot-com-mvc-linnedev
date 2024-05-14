package com.alineatv.alineatv.config;

import java.util.Arrays;

import com.alineatv.alineatv.entities.Aluno;
import com.alineatv.alineatv.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {



    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public void run(String... args) throws Exception {

        Aluno aluno1 = new Aluno(null, "Aline", "ADS", 20 , true);
        Aluno aluno2 = new Aluno(null, "Lebi", "ADS", 30 , true);

        //Manda para o banco de dados
        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2));


    }
}