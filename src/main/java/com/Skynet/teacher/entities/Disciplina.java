package com.Skynet.teacher.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonProperty("aulas")
	@JsonManagedReference
	private List<Aula> aulas;

	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonProperty("turma_disciplinas")
	@JsonManagedReference
	private List<TurmaDisciplina> turmaDisciplinas;

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<TurmaDisciplina> getTurmaDisciplinas() {
		return turmaDisciplinas;
	}

	public void setTurmaDisciplinas(List<TurmaDisciplina> turmaDisciplinas) {
		this.turmaDisciplinas = turmaDisciplinas;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

}
