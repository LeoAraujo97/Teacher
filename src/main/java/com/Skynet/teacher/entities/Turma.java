package com.Skynet.teacher.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private Date anoInicio;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	@JsonBackReference
	private Curso curso;

	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonProperty("alunos")
	@JsonManagedReference
	private List<Aluno> alunos;

	//Dominante sempre quem tem a relacao ManyToMany
	@ManyToMany
	@JoinTable(name = "turma_has_disciplinas", joinColumns = { @JoinColumn(name = "turma_id") }, inverseJoinColumns = {
			@JoinColumn(name = "disciplina_id") })
	private List<Disciplina> disciplinas;
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonProperty("aulas")
	@JsonManagedReference
	private List<Aula> aulas;


	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(Date anoInicio) {
		this.anoInicio = anoInicio;
	}

}
