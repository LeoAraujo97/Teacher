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
}
