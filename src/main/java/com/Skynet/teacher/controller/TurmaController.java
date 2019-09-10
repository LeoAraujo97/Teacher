package com.Skynet.teacher.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Skynet.teacher.service.TurmaService;

@RestController
@RequestMapping("/api")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@RequestMapping(value = "/turmas/", method = RequestMethod.GET)
	public ResponseEntity<?> listarTurmas() {
		System.out.println("teste");
		try {
			return turmaService.listarTurmas();
		}catch (Exception e) {
			System.out.println(e);
			return turmaService.listarTurmas();
		}	
			// TODO: handle exception
	}
	

}
