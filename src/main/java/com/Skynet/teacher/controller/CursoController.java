package com.Skynet.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.Skynet.teacher.entities.Curso;
import com.Skynet.teacher.service.CursoService;

@RestController
@RequestMapping("/api")
public class CursoController {
	@Autowired
	private CursoService cursoServ;

	@RequestMapping(value = "/cursos/", method = RequestMethod.GET)
	public ResponseEntity<?> listarCursos() {

		List<Curso> cursos = cursoServ.listarCursos();
		if (cursos == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
	}

	@RequestMapping(value = "/curso/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> inserirCurso(@RequestBody Curso curso, HttpServletRequest request) {
		Curso insereCurso = cursoServ.inserirCurso(curso);
		if (insereCurso == null) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Curso>(insereCurso, HttpStatus.CREATED);

	}

}
