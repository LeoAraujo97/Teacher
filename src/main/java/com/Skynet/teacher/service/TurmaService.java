package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.Turma;
import com.Skynet.teacher.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;

	public ResponseEntity<List<Turma>> listTurmas() {
		List<Turma> turmas = turmaRepository.findAll();
		if (!turmas.isEmpty())
			return new ResponseEntity<List<Turma>>(turmas, HttpStatus.OK);
		return new ResponseEntity<List<Turma>>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<?> addTurma(Turma turma) {
		String nomeTurma = turma.getNome();
		Turma turmaExistente = turmaRepository.EncontrarTurmaPorNome(nomeTurma);
		if(turmaExistente != null){
			return new ResponseEntity<Turma>(turmaExistente, HttpStatus.OK);
		}
		Turma turmaCriada = turmaRepository.save(turma);
		return new ResponseEntity<Turma>(turmaCriada,HttpStatus.CREATED);
		
	}
}	
	