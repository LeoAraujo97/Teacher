package com.Skynet.teacher.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.Skynet.teacher.entities.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	@Query(value = "SELECT * FROM aluno", nativeQuery = true)
	public List<Aluno> listarAlunos();

	@Query(value = "SELECT * FROM aluno WHERE email =?1", nativeQuery = true)
	public Aluno encontrarAlunoPorEmail(String email);

	public Aluno findAlunoByEmailAndSenha(String email, String senha);
	
	public Aluno findAlunoByEmail(String email);

	@Query(value = "SELECT * FROM aluno A JOIN presenca B on A.ra =B.aluno_id where A.ra = ?1", nativeQuery = true)
	public Aluno encontrarPresencaDoAluno(Long id);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO presenca (aluno_id,aula_id) select :aluno_id,:aula_id", nativeQuery = true)
	public void InserirPresenca(@Param("aluno_id")Long alunoId,@Param("aula_id")Long aulaId);

	@Query(value = "SELECT * FROM presenca WHERE aluno_id =?1 and aula_id =?2", nativeQuery = true)
	public Object encontraPresencaPorAulaEAluno(Long aluno_id, Long aula_id);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM presenca WHERE aluno_id =?1 and aula_id =?2", nativeQuery = true)
	public void deletarPresenca(Long aluno_id, Long aula_id);
}
