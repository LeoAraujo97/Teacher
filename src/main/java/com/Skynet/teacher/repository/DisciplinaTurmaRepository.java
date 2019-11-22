package com.Skynet.teacher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.DisciplinaTurma;

@Repository
public interface DisciplinaTurmaRepository extends JpaRepository<DisciplinaTurma, Long> {

	public List<DisciplinaTurma> findDisciplinaTurmaByprofessor_id(Long professorId);
}
