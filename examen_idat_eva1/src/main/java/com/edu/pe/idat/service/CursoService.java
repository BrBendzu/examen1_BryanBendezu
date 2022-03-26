package com.edu.pe.idat.service;

import java.util.List;

import com.edu.pe.idat.dto.CursoRequestDTO;
import com.edu.pe.idat.dto.CursoResponseDTO;

public interface CursoService {
	
	public void guardarCurso(CursoRequestDTO c);
	public void eliminarCurso(Integer id);
	public void editarProducto(CursoRequestDTO c);
	public List<CursoResponseDTO> listarCursos();
	public CursoResponseDTO cursoById(Integer id);

}
