package com.edu.pe.idat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="malla")
@Entity
public class Malla_curricular {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMalla;
	private String anio;
	
	@OneToMany(mappedBy="malla")
	private List<Curso>curso = new ArrayList<>();
	
	@OneToOne(mappedBy = "malla")
	private Universidad universidad;

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}
	
	

}
