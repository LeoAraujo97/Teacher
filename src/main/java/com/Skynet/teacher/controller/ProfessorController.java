package com.Skynet.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Skynet.teacher.entities.Professor;
import com.Skynet.teacher.service.ProfessorService;

@RestController
@RequestMapping("/api")
public class ProfessorController {
	@Autowired
	private ProfessorService professorServ;
	
	@RequestMapping(value = "/professores/", method = RequestMethod.GET)
	public ResponseEntity<?> listProfessores() {

		return professorServ.listProfessores();
	}

	@RequestMapping(value = "/professor/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> professorWithDisciplinas(@PathVariable("id") long id)
	{
		System.out.println(id);
		return professorServ.findProfessorAndDisciplinas(id);
	}
	@RequestMapping(value = "/professor/", method = RequestMethod.POST)
	public ResponseEntity<?> InserirProfessor(@RequestBody Professor professor )
	{
		return professorServ.cadastraProfessor(professor);
	}
	

}
