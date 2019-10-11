package com.Skynet.teacher.entities;

import org.springframework.stereotype.Component;

@Component
public class Login {

    private String usuario;
    private String senha;

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}