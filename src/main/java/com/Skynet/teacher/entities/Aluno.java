package com.Skynet.teacher.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ra;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("senha")
	private String senha;

	@JsonProperty("email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "turma_id")
	@JsonBackReference
	private Turma turma;
	
	@ManyToMany
	@JoinTable(name = "presenca", joinColumns = { @JoinColumn(name = "aluno_id") }, inverseJoinColumns = {
			@JoinColumn(name = "aula_id") })
	@JsonProperty("presenca")
	private List<Aula> aulas;

	

	public long getRa() {
		return this.ra;
	}

	public void setRa(long ra) {
		this.ra = ra;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

}
