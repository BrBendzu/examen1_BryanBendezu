package com.edu.pe.idat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="curso")
@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idCurso;
	private String curso;
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name="id_malla",nullable=false,unique=true,
	foreignKey= @ForeignKey(foreignKeyDefinition="foreign key(id_malla)references malla(id_malla)"))
	private Malla_curricular malla;
	
	@ManyToMany(mappedBy = "cursos",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Profesor> profesores = new ArrayList<>();

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Malla_curricular getMalla() {
		return malla;
	}

	public void setMalla(Malla_curricular malla) {
		this.malla = malla;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	

}
