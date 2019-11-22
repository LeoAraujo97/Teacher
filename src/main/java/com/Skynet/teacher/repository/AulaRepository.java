package com.Skynet.teacher.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.Skynet.teacher.entities.Aula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
    @Query(value = "SELECT * FROM aula WHERE disciplina_turma_id =?1 AND ocorrida=1", nativeQuery = true)
    public List<Aula> encontrarAulaPelaDisciplinaTurma(long turmaDisciplinaId);

    @Query(value = "SELECT * FROM aula WHERE disciplina_turma_id =?1 and data = ?2 ", nativeQuery = true)
    public List<Aula> FindAulaByDisciplinaTurmaAndDate(long turmaDisciplinaId, String data);

    @Transactional
	@Modifying
	@Query(value = "UPDATE AULA SET OCORRIDA = 1 WHERE id =?1 ", nativeQuery = true)
	public void aulaOcorrida(Long aula_id);
}
