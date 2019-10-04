package com.Skynet.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import com.Skynet.teacher.entities.Curso;
import com.Skynet.teacher.service.CursoService;

@RestController
@RequestMapping("/api")
public class CursoController {
	@Autowired
	private CursoService cursoServ;

	@RequestMapping(value = "/cursos/", method = RequestMethod.GET)
	public ResponseEntity<?> ListarCursos() {

		return cursoServ.ListarCursos();
	}

	@RequestMapping(value = "/curso/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> InserirCurso(@RequestBody Curso curso, HttpServletRequest request) 
	{
		System.out.println(curso.getNome());
		return cursoServ.InserirCurso(curso);
	}

}
