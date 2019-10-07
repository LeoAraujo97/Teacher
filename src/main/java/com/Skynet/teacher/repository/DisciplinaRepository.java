package com.Skynet.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
    @Query(value = "SELECT * FROM Disciplina Where Nome = ?1", nativeQuery = true)
	public Disciplina encontrarDisciplinaPorNome(String nome);
}
