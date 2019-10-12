package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.DisciplinaTurma;
import com.Skynet.teacher.repository.DisciplinaTurmaRepository;

@Service
public class DisciplinaTurmaService {
	@Autowired
	private DisciplinaTurmaRepository disciplinaRepository;

	public List<DisciplinaTurma> listAll() {
		try {
			return disciplinaRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}

	}

	public DisciplinaTurma addDisciplinaTurma(DisciplinaTurma disciplinaTurma) {
		try {
			return disciplinaRepository.save(disciplinaTurma);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	public DisciplinaTurma editDisciplinaTurma(DisciplinaTurma disciplinaTurma) {
		DisciplinaTurma newDisciplinaTurma = disciplinaRepository.findById(disciplinaTurma.getId()).orElse(null);
		if (newDisciplinaTurma != null) {
			disciplinaTurma = newDisciplinaTurma;
			try {
				disciplinaRepository.save(disciplinaTurma);
				return disciplinaTurma;
			} catch (Exception e) {
				System.out.println(e);
				throw e;
			}
		}
		return null;

	}

	public DisciplinaTurma getDisciplinaTurmaById(Long disciplinaTurmaID) {
		try {
			DisciplinaTurma disciplinaTurma = disciplinaRepository.findById(disciplinaTurmaID).orElse(null);
			return disciplinaTurma;
		} catch (Exception e) {
			throw e;
		}

	}
}
