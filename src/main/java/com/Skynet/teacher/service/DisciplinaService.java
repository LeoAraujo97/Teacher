package com.Skynet.teacher.service;

import com.Skynet.teacher.entities.Disciplina;
import com.Skynet.teacher.repository.DisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public Disciplina adicionarDisciplina(Disciplina disciplina) {
        try {
            String nomeDisciplina = disciplina.getNome();
            Disciplina disciplinaExistente = disciplinaRepository.encontrarDisciplinaPorNome(nomeDisciplina);

            if (disciplinaExistente != null) {
                return null;
            }
            Disciplina disciplinaCriada = disciplinaRepository.save(disciplina);

            return disciplinaCriada;

        } catch (Exception e) {
            throw e;
        }
    }

}
