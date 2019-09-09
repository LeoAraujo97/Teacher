package com.Skynet.teacher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Skynet.teacher.service.ProfessorService;

@RestController
@RequestMapping("/api")
public class ProfessorController {

	private ProfessorService professorServ;
	
	@RequestMapping(value = "/professores/", method = RequestMethod.GET)
	public ResponseEntity<?> ListarProfessores() {

		return professorServ.ListarProfessores();
	}
}
