package com.Skynet.teacher.controller;

import java.util.List;

import com.Skynet.teacher.entities.Aluno;
import com.Skynet.teacher.entities.Presenca;
import com.Skynet.teacher.service.AlunoService;
import com.Skynet.teacher.service.AulaService;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AlunoController {
	@Autowired
	private AlunoService alunoServ;

	@Autowired
	private AulaService aulaServ;

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

	@RequestMapping(value = "/aluno/", method = RequestMethod.POST)
	public ResponseEntity<?> alunoInsert(@RequestBody Aluno aluno) {
		Aluno alunoInserted = alunoServ.alunoInsert(aluno);
		if (alunoInserted == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Aluno>(alunoInserted, HttpStatus.CREATED);
	}

	@GetMapping("aluno/presenca/{id}")
	public ResponseEntity<?> alunoPresenca(@PathVariable("id") long id) {
		Aluno aluno = alunoServ.encontrarPresencaDoAluno(id);
		if (aluno == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}

	@GetMapping("aluno/presencaDisciplina/{id}")
	public ResponseEntity<?> alunoPresencaDisciplina(@PathVariable("id") long id,
			@RequestParam("disciplinaTurmaId") long disciplinaTurmaId) {

		try {
			ObjectNode statusPresenca = aulaServ.listarQuantidadePresencaAlunoDisciplina(disciplinaTurmaId, id);
			return new ResponseEntity<ObjectNode>(statusPresenca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("aluno/presenca")
	public ResponseEntity<?> presencaAluno(@RequestBody Presenca presenca) {
		try {
			Boolean inseriuPresenca = alunoServ.inserirPresenca(presenca.getAluno_id(), presenca.getAula_id());
			if (!inseriuPresenca) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>("error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("aluno/presenca")
	public ResponseEntity<?> deletarPresencaAluno(@RequestBody Presenca presenca) {
		try {
			Boolean deletouPresenca = alunoServ.deletarPresenca(presenca.getAluno_id(), presenca.getAula_id());
			if (!deletouPresenca) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<String>("error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
