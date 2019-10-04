package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.Aluno;
import com.Skynet.teacher.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;

	public ResponseEntity<List<Aluno>> listAlunos() {
		List<Aluno> alunos = alunoRepository.findAll();
		if (!alunos.isEmpty())
			return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);

		return new ResponseEntity<List<Aluno>>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Aluno> findAlunoById(long id) {
		Aluno aluno = alunoRepository.findById(id).orElse(null);
		if (aluno != null) {
			return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
		}
		return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> alunoInsert(Aluno aluno) {
		String email = aluno.getEmail();
		Aluno alunoJaCadastrado = alunoRepository.EncontrarAlunoPorEmail(email);
		if (alunoJaCadastrado != null) {
			return new ResponseEntity<String>("Aluno já cadastrado", HttpStatus.BAD_REQUEST);
		}
		try {

			return new ResponseEntity<Aluno>(alunoRepository.save(aluno), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Aluno>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
