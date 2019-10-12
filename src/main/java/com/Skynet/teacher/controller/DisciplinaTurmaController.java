package com.Skynet.teacher.controller;

import java.util.List;

import com.Skynet.teacher.entities.DisciplinaTurma;
import com.Skynet.teacher.service.DisciplinaTurmaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DisciplinaTurmaController {

    @Autowired
    private DisciplinaTurmaService disciplinaTurmaService;

    @GetMapping(value = "/disciplinaTurma/")
    public ResponseEntity<?> getDisciplinaTurma() {
        List<DisciplinaTurma> disciplinaTurmaLista = disciplinaTurmaService.listAll();

        if (disciplinaTurmaLista == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<DisciplinaTurma>>(disciplinaTurmaLista, HttpStatus.OK);
    }

    @GetMapping(value = "/disciplinaTurma/{id}")
    public ResponseEntity<?> getDisciplinasTurmaByID(@PathVariable("id") Long disciplinaTurmaID) {
        try {
            DisciplinaTurma disciplinaTurma = disciplinaTurmaService.getDisciplinaTurmaById(disciplinaTurmaID);
            return new ResponseEntity<DisciplinaTurma>(disciplinaTurma, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
            // TODO: handle exception
        }
    }

    @PostMapping(value = "/disciplinaTurma/")
    public ResponseEntity<?> saveDisciplinaTurma(@RequestBody DisciplinaTurma disciplinaTurma) {
        try {
            DisciplinaTurma disciplinaTurmanew = disciplinaTurmaService.addDisciplinaTurma(disciplinaTurma);
            ObjectMapper obj = new ObjectMapper();
            ObjectNode objNode = obj.createObjectNode();

            objNode.put("message", "Created");
            objNode.put("disciplina_turma_id", disciplinaTurmanew.getId());

            return new ResponseEntity<ObjectNode>(objNode, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
            // TODO: handle exception
        }
    }

    @PutMapping(value = "/disciplinaTurma/")
    public ResponseEntity<?> editDisciplinaTurma(@RequestBody DisciplinaTurma disciplinaTurma) {
        try {
            DisciplinaTurma disciplinaTurmanew = disciplinaTurmaService.editDisciplinaTurma(disciplinaTurma);
            return new ResponseEntity<DisciplinaTurma>(disciplinaTurmanew, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
            // TODO: handle exception
        }
    }

}