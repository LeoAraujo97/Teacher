package com.Skynet.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.Skynet.teacher.entities.DisciplinaTurma;
import com.Skynet.teacher.entities.Turma;
import com.Skynet.teacher.service.TurmaService;

@RestController
@RequestMapping("/api")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@RequestMapping(value = "/turmas/", method = RequestMethod.GET)
	public ResponseEntity<?> listTurmas() {

		List<Turma> turmas = turmaService.listTurmas();

		if (turmas == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Turma>>(turmas, HttpStatus.OK);

	}

	@GetMapping(value = "/turma/{id}")
	public ResponseEntity<?> getDisciplinaById(@PathVariable Long id) {

		Turma turma = turmaService.getDisciplinaById(id);

		if (turma == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Turma>(turma, HttpStatus.OK);

	}

	@GetMapping(value = "/turma/disciplinas/{id}")
	public ResponseEntity<?> listDisciplinasofTurma(@PathVariable Long id) {

		List<DisciplinaTurma> discipTurma = turmaService.getDisciplinaById(id).getDisciplinaTurma();

		if (discipTurma.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<DisciplinaTurma>>(discipTurma, HttpStatus.OK);

	}

	@RequestMapping(value = "/turma/", method = RequestMethod.POST)
	public ResponseEntity<?> inserirTurma(@RequestBody Turma turma) {
		Turma turmaInserida = turmaService.addTurma(turma);

		if (turmaInserida == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Turma>(turmaInserida, HttpStatus.CREATED);
	}

}
