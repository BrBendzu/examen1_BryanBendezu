package com.edu.pe.idat.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="universidad")
@Entity
public class Universidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUniversidad;
	private String universidad;
	
	@OneToOne
	@JoinColumn(name = "id_malla",nullable=false,unique=true,
	foreignKey= @ForeignKey(foreignKeyDefinition="foreign key(id_malla)references malla(id_malla)"))
	private Malla_curricular malla;

	public Integer getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public Malla_curricular getMalla() {
		return malla;
	}

	public void setMalla(Malla_curricular malla) {
		this.malla = malla;
	}
	
	

}
