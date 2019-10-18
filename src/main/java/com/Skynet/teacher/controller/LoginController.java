package com.Skynet.teacher.controller;

import javax.servlet.http.HttpServletRequest;

import com.Skynet.teacher.entities.Aluno;
import com.Skynet.teacher.entities.Professor;
import com.Skynet.teacher.service.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login/")
    public ResponseEntity<?> realizarLogin(@RequestBody String body, @RequestParam("userType") String userType,
            HttpServletRequest request) {
        Object obj = loginService.realizarLogin(userType, body);

        ObjectMapper objMapper = new ObjectMapper();
        ObjectNode objNode = objMapper.createObjectNode();

        if (obj != null) {
            request.getSession().setAttribute("usuarioLogado", true);
            if (obj instanceof Aluno) {
                Aluno aluno = (Aluno) obj;
                objNode.put("ra", aluno.getRa());
                objNode.put("nome", aluno.getNome());
                objNode.put("email", aluno.getNome());
                objNode.put("turma_id", aluno.getTurma().getId());
                return new ResponseEntity<ObjectNode>(objNode, HttpStatus.OK);
            } else {
                return new ResponseEntity<Professor>((Professor) obj, HttpStatus.OK);

            }

        }
        objNode.put("message", "Unable to find user");
        return new ResponseEntity<ObjectNode>(objNode, HttpStatus.UNAUTHORIZED);
    }
}
