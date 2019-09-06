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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	@JsonProperty("ano")
	private Date AnoInicio;

	@ManyToOne
	@JoinColumn(name = "CursoId")
	Curso Curso;
	
	@OneToMany(mappedBy = "Turma", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonProperty("disciplinas")
	List<Disciplina>Disciplinas;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getAnoInicio() {
		return AnoInicio;
	}

	public void setAnoInicio(Date anoInicio) {
		AnoInicio = anoInicio;
	}

}
