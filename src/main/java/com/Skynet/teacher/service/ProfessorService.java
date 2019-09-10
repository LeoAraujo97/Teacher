package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.Professor;
import com.Skynet.teacher.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	private ProfessorRepository professorRepository;
	
	public ResponseEntity<List<Professor>> ListarProfessores(){
		List<Professor> professores = professorRepository.findAll();
		
		if(!professores.isEmpty())
			return new ResponseEntity<List<Professor>>(professores, HttpStatus.OK);
		
		return new ResponseEntity<List<Professor>>(HttpStatus.NOT_FOUND);
		
	}

	
}
