package com.Skynet.teacher.service;

import com.Skynet.teacher.entities.Login;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private ProfessorService profService;

    @Autowired
    private AlunoService alunoService;

    public Object realizarLogin(String userType, String body) {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = null;
        System.out.println(body);
        try {
            Login login = mapper.readValue(body, Login.class);
            if ("professor".equals(userType)) {
                obj = profService.encontrarProfessorPorEmailESenha(login.getUsuario(), login.getSenha());
            } else {
                obj = alunoService.encontrarAlunoPorEmailESenha(login.getUsuario(), login.getSenha());
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Nao foi possivel converter para a classe Login");
        }
        return obj;
    }
}
