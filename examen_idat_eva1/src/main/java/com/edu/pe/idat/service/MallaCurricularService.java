package com.edu.pe.idat.service;

import java.util.List;

import com.edu.pe.idat.dto.MallaRequestDTO;
import com.edu.pe.idat.dto.MallaResponseDTO;

public interface MallaCurricularService {
	public void guardarMallaCurricular(MallaRequestDTO m);
	public void eliminarMallCurricular(Integer id);
	public void editarMallCurricular(MallaRequestDTO m);
	public List<MallaResponseDTO> listarMallaCurricular();
	public MallaResponseDTO MallaCurricularById(Integer id);

}
