package com.Skynet.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Skynet.teacher.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
