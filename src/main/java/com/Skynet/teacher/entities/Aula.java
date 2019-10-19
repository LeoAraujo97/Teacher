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
public class Aula implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonProperty("data")
	private String data;

	@ManyToOne
	@JoinColumn(name = "disciplina_turma_id")
	@JsonBackReference
	private DisciplinaTurma disciplinaTurma;

	@JsonProperty("horario")
	private String horario;

	@JsonProperty("ocorrida")
	private boolean ocorrida;

	public boolean isOcorrida() {
		return this.ocorrida;
	}

	public boolean getOcorrida() {
		return this.ocorrida;
	}

	public void setOcorrida(boolean ocorrida) {
		this.ocorrida = ocorrida;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public DisciplinaTurma getDisciplinaTurma() {
		return this.disciplinaTurma;
	}

	public void setDisciplinaTurma(DisciplinaTurma disciplinaTurma) {
		this.disciplinaTurma = disciplinaTurma;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
