package com.Skynet.teacher.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonProperty("nome")
	@Column(nullable = false, length = 1000)
	private String nome;

	@OneToMany()
	private List<DisciplinaTurma> disciplinasTurma;

	public long getId() {
		return this.id;
	}

	public List<DisciplinaTurma> getDisciplinasTurma() {
		return disciplinasTurma;
	}

	public void setDisciplinasTurma(List<DisciplinaTurma> disciplinasTurma) {
		this.disciplinasTurma = disciplinasTurma;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
