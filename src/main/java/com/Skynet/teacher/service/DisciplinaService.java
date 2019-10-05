package com.Skynet.teacher.service;

import com.Skynet.teacher.entities.Disciplina;
import com.Skynet.teacher.repository.DisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public ResponseEntity<?> adicionarDisciplina(Disciplina disciplina) {
        String nomeDisciplina = disciplina.getNome();
        Disciplina disciplinaExistente = disciplinaRepository.EncontrarDisciplinaPorNome(nomeDisciplina);

        if (disciplinaExistente != null) {
            return new ResponseEntity<Disciplina>(disciplinaExistente, HttpStatus.OK);
        }
        Disciplina disciplinaCriada = disciplinaRepository.save(disciplina);

        return new ResponseEntity<Disciplina>(disciplinaCriada, HttpStatus.CREATED);
    }

}
