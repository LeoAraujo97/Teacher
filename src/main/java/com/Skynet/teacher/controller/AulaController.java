package com.Skynet.teacher.controller;

import com.Skynet.teacher.entities.Aula;
import com.Skynet.teacher.service.AulaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @PostMapping()
    public ResponseEntity<?> inserirAula(@RequestBody Aula aula) {
        try {
            if (aula.getId() != 0) {
                Aula aulaExistente = aulaService.aulaById(aula.getId());
                if (aulaExistente != null) {
                    return new ResponseEntity<String>("Aula já existe com esse Id.", HttpStatus.BAD_REQUEST);
                }
            }

            Aula aulaCriada = aulaService.insertAula(aula);
            return new ResponseEntity<Aula>(aulaCriada, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("aulaOcorrida/{id}")
    public ResponseEntity<?> aulaOcorrida(@PathVariable("id") Long aulaId) {
        try {
            if(aulaService.alterarAula(aulaId)){
                return new ResponseEntity<>( HttpStatus.OK);
            }
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}