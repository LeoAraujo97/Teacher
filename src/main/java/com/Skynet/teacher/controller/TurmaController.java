package com.Skynet.teacher.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Skynet.teacher.entities.Turma;
import com.Skynet.teacher.service.TurmaService;

@RestController
@RequestMapping("/api")
public class TurmaController 
{
	
	@Autowired
	private TurmaService turmaService;
	
	@RequestMapping(value = "/turmas/", method = RequestMethod.GET)
	public ResponseEntity<?> listTurmas()
	{
		System.out.println("teste");
		try 
		{
			return turmaService.listTurmas();
		}catch (Exception e) 
		{
			System.out.println(e);
			return turmaService.listTurmas();
		}	
	}	

	@RequestMapping(value = "/turma/", method = RequestMethod.POST)
	public ResponseEntity<?> InserirTurma(@RequestBody Turma turma)
	{
		return turmaService.addTurma(turma);
	}

}
