package com.Skynet.teacher.entities;

import java.io.Serializable;

public class Presenca implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long aula_id;
    private Long aluno_id;

    public Long getAula_id() {
        return this.aula_id;
    }

    public void setAula_id(Long aula_id) {
        this.aula_id = aula_id;
    }

    public Long getAluno_id() {
        return this.aluno_id;
    }

    public void setAluno_id(Long aluno_id) {
        this.aluno_id = aluno_id;
    }
}