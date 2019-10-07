package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.Aluno;
import com.Skynet.teacher.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> listAlunos() {
		try {
			List<Aluno> alunos = alunoRepository.findAll();
			if (alunos.isEmpty()) {

				return null;
			}
			return alunos;
		} catch (Exception e) {
			throw e;
		}
	}

	public Aluno findAlunoById(long id) {
		try {
			Aluno aluno = alunoRepository.findById(id).orElse(null);
			return aluno;
		} catch (Exception e) {
			throw e;
		}
	}

	public Aluno alunoInsert(Aluno aluno) {
		try {
			String email = aluno.getEmail();
			Aluno alunoJaCadastrado = alunoRepository.encontrarAlunoPorEmail(email);
			if (alunoJaCadastrado != null) {
				return null;
			}
			return alunoRepository.save(aluno);

		} catch (Exception e) {
			throw e;
		}
	}
}
