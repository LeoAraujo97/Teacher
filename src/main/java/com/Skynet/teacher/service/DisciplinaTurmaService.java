package com.Skynet.teacher.service;

import java.util.ArrayList;
import java.util.List;

import com.Skynet.teacher.entities.Aluno;
import com.Skynet.teacher.entities.Aula;
import com.Skynet.teacher.entities.DisciplinaTurma;
import com.Skynet.teacher.entities.Turma;
import com.Skynet.teacher.repository.AlunoRepository;
import com.Skynet.teacher.repository.AulaRepository;
import com.Skynet.teacher.repository.DisciplinaTurmaRepository;
import com.Skynet.teacher.repository.TurmaRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaTurmaService {
	@Autowired
	private DisciplinaTurmaRepository disciplinaTurmaRepository;
	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private AulaRepository aulaRepository;
	@Autowired
	private AlunoRepository alunoRepository;

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

	public Aula getDisciplinaTurmaAulaDoDia(Long disciplinaTurmaID, String data) {
		try {
			DisciplinaTurma disciplinaTurma = disciplinaTurmaRepository.findById(disciplinaTurmaID).orElse(null);
			if (disciplinaTurma != null) {
				for (Aula aula : disciplinaTurma.getAulas()) {
					if (data.equals(aula.getData())) {
						return aula;
					}
				}
			}
			return null;
		} catch (Exception e) {
			throw e;
		}

	}

	public List<Object> getDisciplinasProfessorById(Long professorId) {
		List<DisciplinaTurma> listDisciplinaTurma = disciplinaTurmaRepository
				.findDisciplinaTurmaByprofessor_id(professorId);
		List<Object> listaRetorno = new ArrayList<>();

		ObjectMapper objMapper = new ObjectMapper();
		ObjectNode objNode = objMapper.createObjectNode();

		if (listaRetorno.isEmpty()) {
			for (DisciplinaTurma dispTurma : listDisciplinaTurma) {
				JsonNode node = objMapper.valueToTree(dispTurma);
				objNode.set("disciplina", node);
				objNode.put("turma", dispTurma.getTurma().getNome());
				System.out.println(dispTurma.getTurma().getNome());
				listaRetorno.add(objNode);
			}
		} else {
			listaRetorno.add(objNode.put("message", "Nao existem disciplinas"));
		}
		return listaRetorno;
	}

	public List<Aluno> disciplinaTurmaAlunos(String data, Long id) {
		try {
			DisciplinaTurma disciplinaTurma = disciplinaTurmaRepository.findById(id).orElse(null);
			Long turmaId = disciplinaTurma.getTurma().getId();

			Turma turma = turmaRepository.findById(turmaId).orElse(null);
			return turma.getAlunos();

		} catch (Exception e) {
			return null;
		}
	}
}
