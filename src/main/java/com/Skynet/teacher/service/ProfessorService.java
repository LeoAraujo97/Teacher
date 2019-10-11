package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.Professor;
import com.Skynet.teacher.repository.ProfessorRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;

	public List<Professor> listProfessores() {
		try {
			List<Professor> professores = professorRepository.findAll();

			if (professores.isEmpty())
				return null;

			return professores;

		} catch (Exception e) {
			throw e;
		}

	}

	public Professor findProfessorAndDisciplinas(long id) {
		try {
			Professor professor = professorRepository.findById(id).orElse(null);
			return professor;
		} catch (Exception e) {
			throw e;
		}
	}

	public Professor cadastraProfessor(Professor professor) {
		try {
			String email = professor.getEmail();
			Professor professorExistente = professorRepository.encontraProfessorPorEmail(email);
			if (professorExistente != null) {

				return null;
			}
			return professorRepository.save(professor);
		} catch (Exception e) {
			throw e;
		}
	}

	public Professor encontrarProfessorPorEmailESenha(String email, String senha) {
		try {
			Professor professor = professorRepository.findProfessorByEmailAndSenha(email, senha);
			System.out.println(professor.getNome());
			return professor;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
