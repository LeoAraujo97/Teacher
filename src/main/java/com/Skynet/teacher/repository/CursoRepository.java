package com.Skynet.teacher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Skynet.teacher.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	@Query(value = "SELECT * FROM Curso", nativeQuery = true)
	public List<Curso> ListarCursos();

}
