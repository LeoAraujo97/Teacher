package com.Skynet.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long>{
    @Query(value = "SELECT * FROM ALUNO WHERE EMAIL =?1", nativeQuery = true)
    public Aula EncontrarAlunoPorEmail(String email);
}
