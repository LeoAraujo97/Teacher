package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.Professor;
import com.Skynet.teacher.repository.ProfessorRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;
	
	public ResponseEntity<List<Professor>> listProfessores(){
		List<Professor> professores = professorRepository.findAll();
		
		if(!professores.isEmpty())
			return new ResponseEntity<List<Professor>>(professores, HttpStatus.OK);
		
		return new ResponseEntity<List<Professor>>(HttpStatus.NOT_FOUND);
		
	}

	public ResponseEntity<Professor> findProfessorAndDisciplinas(long id)
	{
			Professor professor = professorRepository.findById(id).orElse(null);
			if(professor != null)
			{
				return new ResponseEntity<>(professor, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
}
