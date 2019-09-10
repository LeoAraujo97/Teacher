package com.Skynet.teacher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	@Query(value = "Select * from Professor", nativeQuery = true )
	public List<Professor> ListarProfessores();
	
}
