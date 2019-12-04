package com.Skynet.teacher.service;

import java.util.List;

import com.Skynet.teacher.entities.Aluno;
import com.Skynet.teacher.repository.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Aluno encontrarAlunoPorEmailESenha(String email, String senha) {
		try {
			Aluno aluno = alunoRepository.findAlunoByEmailAndSenha(email, senha);
			System.out.println(aluno.getNome());
			return aluno;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public Aluno encontrarPresencaDoAluno(Long id) {
		try {
			Aluno aluno = alunoRepository.encontrarPresencaDoAluno(id);
			return aluno;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public Integer inserirPresenca(Long alunoId, Long aulaId) {
		try {
			Object presecaExistente = alunoRepository.encontraPresencaPorAulaEAluno(alunoId, aulaId);
			if (presecaExistente != null) {
				return 0;
			}

			alunoRepository.InserirPresenca(alunoId, aulaId);
			Integer quantidade = alunoRepository.quantidadePresentes(aulaId);
		
			return quantidade;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	public Boolean deletarPresenca(Long alunoId, Long aulaId) {
		try {
			Object presecaExistente = alunoRepository.encontraPresencaPorAulaEAluno(alunoId, aulaId);
			if (presecaExistente == null) {
				return false;
			}
			try {
				alunoRepository.deletarPresenca(alunoId, aulaId);
				return true;
			} catch (Exception e) {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Aluno encontrarAlunoPorEmail(String email) {
		try {
			Aluno aluno = alunoRepository.findAlunoByEmail(email);
			System.out.println(aluno.getNome());
			return aluno;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
}
