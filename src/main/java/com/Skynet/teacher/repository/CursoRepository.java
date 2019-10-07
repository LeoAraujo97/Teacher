package com.Skynet.teacher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	@Query(value = "SELECT * FROM Curso", nativeQuery = true)
	public List<Curso> listarCursos();

	@Query(value = "SELECT * FROM CURSO WHERE NOME = ?1", nativeQuery = true)
	public Curso buscaCursoPeloNome(String nome);
}

