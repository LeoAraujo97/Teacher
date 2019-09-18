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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class DisciplinaTurma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonProperty("turma")
	@ManyToOne
	@JoinColumn(name = "turma_id")
	@JsonBackReference
	private Turma turma;

	@OneToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	@JsonProperty("diasDaSemana")
	private String diaDaSemana;
	
	@OneToMany(mappedBy = "disciplinaTurma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonProperty("aulas")
	@JsonManagedReference
	private List<Aula> aulas;
	
	@JsonProperty("unidade")
	private String unidade;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getDiaDaSemana() {
		return this.diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
}
