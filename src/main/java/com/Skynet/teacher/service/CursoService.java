package com.Skynet.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Skynet.teacher.entities.Curso;
import com.Skynet.teacher.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public List<Curso> listarCursos() {
		try {
			List<Curso> cursos = cursoRepository.findAll();
			if (!cursos.isEmpty())
				return cursos;

			return null;

		} catch (Exception e) {
			throw e;
		}
	}

	public Curso inserirCurso(Curso curso) {
		try {

			String nomeDoCurso = curso.getNome();
			Curso cursoExistente = cursoRepository.buscaCursoPeloNome(nomeDoCurso);
			if (cursoExistente != null) {
				return null;
			}

			return cursoRepository.save(curso);
		} catch (Exception e) {
			throw e;
		}
	}

}
