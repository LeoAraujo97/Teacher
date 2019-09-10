package com.Skynet.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Skynet.teacher.service.AlunoService;

@RestController
@RequestMapping("/api")
public class AlunoController {
	@Autowired
	private AlunoService alunoServ;
	
	@RequestMapping(value = "/alunos/", method = RequestMethod.GET)
	public ResponseEntity<?> ListarAlunos() {

		return alunoServ.ListarAlunos();
	}
}
