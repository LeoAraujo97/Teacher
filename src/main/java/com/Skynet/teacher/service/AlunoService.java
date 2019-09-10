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

	public ResponseEntity<List<Aluno>> ListarAlunos() {
		List<Aluno> alunos = alunoRepository.findAll();
		if (!alunos.isEmpty())
			return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);

		return new ResponseEntity<List<Aluno>>(HttpStatus.NOT_FOUND);
	}
}
