package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.Turma;
import com.Skynet.teacher.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public List<Turma> listTurmas() {
		List<Turma> turmas = turmaRepository.findAll();
		if (!turmas.isEmpty())
			return turmas;
		return null;
	}

	public Turma addTurma(Turma turma) {
		try {
			String nomeTurma = turma.getNome();
			Turma turmaExistente = turmaRepository.encontrarTurmaPorNome(nomeTurma);
			if (turmaExistente != null) {
				return null;
			}
			return turmaRepository.save(turma);

		} catch (Exception e) {
			throw e;
		}
	}

	public Turma getDisciplinaById(Long turmaId) {
		return turmaRepository.findById(turmaId).orElse(null);

	}
}
