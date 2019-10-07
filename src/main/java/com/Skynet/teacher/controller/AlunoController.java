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

import com.Skynet.teacher.entities.Aluno;
import com.Skynet.teacher.service.AlunoService;

@RestController
@RequestMapping("/api")
public class AlunoController {
	@Autowired
	private AlunoService alunoServ;

	@RequestMapping(value = "/alunos/", method = RequestMethod.GET)
	public ResponseEntity<?> listAlunos() {
		List<Aluno> alunos = alunoServ.listAlunos();
		if (alunos == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
	}

	@RequestMapping(value = "/alunos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> alunoById(@PathVariable("id") long id) {
		Aluno aluno = alunoServ.findAlunoById(id);
		if (aluno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}

	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
	public ResponseEntity<?> alunoInsert(@RequestBody Aluno aluno) {
		Aluno alunoInserted = alunoServ.alunoInsert(aluno);
		if (alunoInserted == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Aluno>(alunoInserted, HttpStatus.CREATED);
	}
}
