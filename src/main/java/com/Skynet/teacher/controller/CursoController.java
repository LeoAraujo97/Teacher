package com.Skynet.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Skynet.teacher.service.CursoService;

@RestController
@RequestMapping("/api")
public class CursoController {
	@Autowired
	private CursoService cursoServ;

	@RequestMapping(value = "/Cursos/", method = RequestMethod.GET)
	public ResponseEntity<?> ListarCursos() {

		return cursoServ.ListarCursos();
	}

}
