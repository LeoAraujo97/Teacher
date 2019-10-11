package com.Skynet.teacher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Skynet.teacher.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	@Query(value = "SELECT * FROM Aluno", nativeQuery = true)
	public List<Aluno> listarAlunos();

	@Query(value = "SELECT * FROM ALUNO WHERE EMAIL =?1", nativeQuery = true)
	public Aluno encontrarAlunoPorEmail(String email);

	public Aluno findAlunoByEmailAndSenha(String email, String senha);

	@Query(value = "SELECT * FROM Aluno A JOIN presenca B on A.ra =B.aluno_id where A.ra = ?1", nativeQuery = true)
	public Aluno encontrarPresencaDoAluno(Long id);
}
