package com.edu.pe.idat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.pe.idat.dto.MallaRequestDTO;
import com.edu.pe.idat.dto.MallaResponseDTO;
import com.edu.pe.idat.model.Malla_curricular;
import com.edu.pe.idat.repository.MallaCurricularRepository;

public class MallaCurricularServiceImp implements MallaCurricularService{
	
	@Autowired
	private MallaCurricularRepository repository;

	@Override
	public void guardarMallaCurricular(MallaRequestDTO m) {
		
		Malla_curricular malla = new Malla_curricular();
		malla.setIdMalla(m.getIdRequest());
		malla.setAnio(m.getAnio());		
		repository.save(malla);

		
	}

	@Override
	public void eliminarMallCurricular(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarMallCurricular(MallaRequestDTO m) {
		Malla_curricular malla = new Malla_curricular();
		malla.setIdMalla(m.getIdRequest());
		malla.setAnio(m.getAnio());	
		repository.saveAndFlush(malla);
		
	}

	@Override
	public List<MallaResponseDTO> listarMallaCurricular() {
		
		List<Malla_curricular>malla= repository.findAll();
		
		List<MallaResponseDTO>dto = new ArrayList<MallaResponseDTO>();
		MallaResponseDTO mallaDTO = null;
		
		for(Malla_curricular mallas:malla) {
			mallaDTO = new MallaResponseDTO();
			mallaDTO.setIdResponse(mallas.getIdMalla());
			mallaDTO.setAnio(mallas.getAnio());
			dto.add(mallaDTO);
		}
		
		
		
		
		return dto;
	}

	@Override
	public MallaResponseDTO MallaCurricularById(Integer id) {
		Malla_curricular malla = repository.findById(id).orElse(null);
		MallaResponseDTO mallaDto = new MallaResponseDTO();
		
		mallaDto = new MallaResponseDTO();
		mallaDto.setIdResponse(malla.getIdMalla());
		mallaDto.setAnio(malla.getAnio());
		return mallaDto;
	}

}
