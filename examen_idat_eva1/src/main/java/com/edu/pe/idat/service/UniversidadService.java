package com.edu.pe.idat.service;

import java.util.List;

import com.edu.pe.idat.dto.UniversidadRequestDTO;
import com.edu.pe.idat.dto.UniversidadResponseDTO;

public interface UniversidadService {
	
	public void guardarUniversidad(UniversidadRequestDTO c);
	public void eliminarUniversidad(Integer id);
	public void editarUniversidad(UniversidadRequestDTO c);
	public List<UniversidadResponseDTO> listarUniversidad();
	public UniversidadResponseDTO universidadById(Integer id);

}
