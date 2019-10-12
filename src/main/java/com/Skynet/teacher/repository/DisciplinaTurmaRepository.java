package com.Skynet.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.DisciplinaTurma;

@Repository
public interface DisciplinaTurmaRepository extends JpaRepository<DisciplinaTurma, Long> {

}
