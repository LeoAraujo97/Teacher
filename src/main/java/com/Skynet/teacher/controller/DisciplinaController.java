package com.Skynet.teacher.controller;

import java.util.List;

import com.Skynet.teacher.entities.Disciplina;
import com.Skynet.teacher.service.DisciplinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DisciplinaController {
    @Autowired
    DisciplinaService disciplinaService;

    @RequestMapping(value = "/disciplina/", method = RequestMethod.POST)
    public ResponseEntity<?> inserirDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina cadastroDisciplina = disciplinaService.adicionarDisciplina(disciplina);

        if (cadastroDisciplina == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Disciplina>(cadastroDisciplina, HttpStatus.CREATED);
    }

    @GetMapping("/disciplinas/")
    public ResponseEntity<?> listarDisciplinas() {
        List<Disciplina> listDiscplinas = disciplinaService.listarDisplinas();

        if (listDiscplinas == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<List<Disciplina>>(listDiscplinas, HttpStatus.OK);
    }

}
