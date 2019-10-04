package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.Curso;
import com.Skynet.teacher.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public ResponseEntity<List<Curso>> ListarCursos() {
		List<Curso> cursos = cursoRepository.findAll();
		if (!cursos.isEmpty())
			return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);

		return new ResponseEntity<List<Curso>>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> InserirCurso(Curso curso) {
		String nomeDoCurso = curso.getNome();
		Curso cursoExistente = cursoRepository.buscaCursoPeloNome(nomeDoCurso);
		if(cursoExistente != null){
			return new ResponseEntity<String>("Curso já cadastrado", HttpStatus.BAD_REQUEST);
		}

		Curso cursoCriado =  cursoRepository.save(curso);

		return new ResponseEntity<Curso>(cursoCriado, HttpStatus.CREATED);
	}

}
