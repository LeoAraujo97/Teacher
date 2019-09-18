package com.Skynet.teacher.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@JsonProperty("ano")
	private String anoInicio;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	@JsonBackReference
	private Curso curso;

	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonProperty("alunos")
	@JsonManagedReference
	private List<Aluno> alunos;

	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonProperty("disciplina_turma")
	@JsonManagedReference
	private List<DisciplinaTurma> disciplinaTurma;



	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getAnoInicio() {
		return this.anoInicio;
	}

	public void setAnoInicio(String anoInicio) {
		this.anoInicio = anoInicio;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<DisciplinaTurma> getDisciplinaTurma() {
		return this.disciplinaTurma;
	}

	public void setDisciplinaTurma(List<DisciplinaTurma> disciplinaTurma) {
		this.disciplinaTurma = disciplinaTurma;
	}

}
