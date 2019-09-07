package com.Skynet.teacher.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PresencaAluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JsonProperty("aluno")
	@JoinColumn(name = "aluno_id")
	@JsonBackReference
	private Aluno aluno;

	@ManyToOne
	@JsonProperty("aula")
	@JoinColumn(name = "aula_id")
	@JsonBackReference
	private Aluno aula;

	@JsonProperty("presente")
	private boolean presente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getAula() {
		return aula;
	}

	public void setAula(Aluno aula) {
		this.aula = aula;
	}

	public boolean isPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}

}
