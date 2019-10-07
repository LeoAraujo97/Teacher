package com.Skynet.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.Skynet.teacher.entities.Professor;
import com.Skynet.teacher.service.ProfessorService;

@RestController
@RequestMapping("/api")
public class ProfessorController {
	@Autowired
	private ProfessorService professorServ;

	@RequestMapping(value = "/professores/", method = RequestMethod.GET)
	public ResponseEntity<?> listProfessores() {
		List<Professor> professores = professorServ.listProfessores();
		if (professores == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Professor>>(professores, HttpStatus.OK);
	}

	@RequestMapping(value = "/professor/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> professorWithDisciplinas(@PathVariable("id") long id) {
		Professor professor = professorServ.findProfessorAndDisciplinas(id);
		if (professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Professor>(professor, HttpStatus.OK);
	}

	@RequestMapping(value = "/professor/", method = RequestMethod.POST)
	public ResponseEntity<?> inserirProfessor(@RequestBody Professor professor) {
		Professor professorCriado = professorServ.cadastraProfessor(professor);

		if (professorCriado == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Professor>(professorCriado, HttpStatus.CREATED);
	}

}
