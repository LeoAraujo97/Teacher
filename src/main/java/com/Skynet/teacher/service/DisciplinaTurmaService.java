package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.DisciplinaTurma;
import com.Skynet.teacher.repository.DisciplinaTurmaRepository;

@Service
public class DisciplinaTurmaService {
	@Autowired
	private DisciplinaTurmaRepository disciplinaTurmaRepository;

	public List<DisciplinaTurma> listAll() {
		try {
			return disciplinaTurmaRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}

	}

	public DisciplinaTurma addDisciplinaTurma(DisciplinaTurma disciplinaTurma) {
		try {
			return disciplinaTurmaRepository.save(disciplinaTurma);
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}

	public DisciplinaTurma editDisciplinaTurma(DisciplinaTurma disciplinaTurma) {
		DisciplinaTurma newDisciplinaTurma = disciplinaTurmaRepository.findById(disciplinaTurma.getId()).orElse(null);
		if (newDisciplinaTurma != null) {
			disciplinaTurma = newDisciplinaTurma;
			try {
				disciplinaTurmaRepository.save(disciplinaTurma);
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
			DisciplinaTurma disciplinaTurma = disciplinaTurmaRepository.findById(disciplinaTurmaID).orElse(null);
			return disciplinaTurma;
		} catch (Exception e) {
			throw e;
		}

	}
	
	public List<DisciplinaTurma> getDisciplinasProfessorById(Long professorId) {
		return disciplinaTurmaRepository.findDisciplinaTurmaByprofessor_id(professorId);
	}
}
