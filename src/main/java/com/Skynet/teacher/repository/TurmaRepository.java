package com.Skynet.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.Turma;

@Repository
public interface TurmaRepository  extends JpaRepository<Turma, Long> {
    @Query(value = "SELECT * FROM TURMA WHERE nome =?1", nativeQuery = true)
    public Turma encontrarTurmaPorNome(String nome);
}