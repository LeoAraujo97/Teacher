package com.Skynet.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.PresencaAluno;

@Repository
public interface PresencaAlunoRepository extends JpaRepository<PresencaAluno, Long> {

}
