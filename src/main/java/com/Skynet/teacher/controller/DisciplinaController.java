package com.Skynet.teacher.controller;

import com.Skynet.teacher.entities.Disciplina;
import com.Skynet.teacher.service.DisciplinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DisciplinaController
{
    @Autowired
    DisciplinaService disciplinaService;

    @RequestMapping(value = "/disciplina/", method = RequestMethod.POST)
	public ResponseEntity<?> InserirDisciplina(@RequestBody Disciplina disciplina )
	{
		return disciplinaService.adicionarDisciplina(disciplina);
	}

}