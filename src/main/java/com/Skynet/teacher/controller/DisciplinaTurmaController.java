package com.Skynet.teacher.controller;

import java.util.List;

import com.Skynet.teacher.entities.Aluno;
import com.Skynet.teacher.entities.Aula;
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
import org.springframework.web.bind.annotation.RequestParam;
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
        }
    }

    @PutMapping(value = "/disciplinaTurma/")
    public ResponseEntity<?> editDisciplinaTurma(@RequestBody DisciplinaTurma disciplinaTurma) {
        try {
            DisciplinaTurma disciplinaTurmanew = disciplinaTurmaService.editDisciplinaTurma(disciplinaTurma);
            return new ResponseEntity<DisciplinaTurma>(disciplinaTurmanew, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
        }
    }

    // Retorna todas as disciplinas de um professor e o ID da turma
    @GetMapping(value = "/disciplinasProfessor/{id}")
    public ResponseEntity<?> getDisciplinasProfessorByID(@PathVariable("id") Long professorId) {
        try {
            List<Object> listDisciplinaTurma = disciplinaTurmaService.getDisciplinasProfessorById(professorId);
            return new ResponseEntity<Object>(listDisciplinaTurma, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/disciplinaTurma/{id}/aulaDia")
    public ResponseEntity<?> getAulaDoDia(@PathVariable("id") Long disciplinaTurmaId,
            @RequestParam("data") String data) {
        try {
            Aula aula = disciplinaTurmaService.getDisciplinaTurmaAulaDoDia(disciplinaTurmaId, data);
            if (aula != null) {
                return new ResponseEntity<Aula>(aula, HttpStatus.OK);
            }
            ObjectMapper objmapper = new ObjectMapper();
            ObjectNode objNode = objmapper.createObjectNode();
            objNode.put("message", "Nao existe aula na data de hoje");
            return new ResponseEntity<ObjectNode>(objNode, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/disciplinaTurma/alunos/{id}/")
    public ResponseEntity<?> listarAulnos(@PathVariable("id") Long disciplinaTurma,
            @RequestParam("data") String data) {
        try {
            List<Aluno> alunos = disciplinaTurmaService.disciplinaTurmaAlunos(data, disciplinaTurma);
            if (alunos.isEmpty() || alunos == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
