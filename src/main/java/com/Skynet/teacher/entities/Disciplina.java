package com.Skynet.teacher.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
