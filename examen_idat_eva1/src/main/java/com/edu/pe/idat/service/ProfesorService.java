package com.edu.pe.idat.service;

import java.util.List;

import com.edu.pe.idat.dto.ProfesorRequestDTO;
import com.edu.pe.idat.dto.ProfesorResponseDTO;

public interface ProfesorService {
	
	public void guardarProfesor(ProfesorRequestDTO c);
	public void eliminarProfesor(Integer id);
	public void editarProfesor(ProfesorRequestDTO c);
	public List<ProfesorResponseDTO> listarProfesor();
	public ProfesorResponseDTO profesorById(Integer id);

}
