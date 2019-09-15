package com.Skynet.teacher.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Aula implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonProperty("data")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "disciplina_turma_id")
	@JsonBackReference
	private DisciplinaTurma disciplinaTurma;
	
	@OneToOne
	@JoinColumn(name = "disciplina_id")
	@JsonProperty("disciplina")
	private Disciplina disciplina;
	
	@JsonProperty("horario")
	private String horario;

	public DisciplinaTurma getDisciplinaTurma() {
		return disciplinaTurma;
	}

	public void setDisciplinaTurma(DisciplinaTurma disciplinaTurma) {
		this.disciplinaTurma = disciplinaTurma;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	
	
	

}
