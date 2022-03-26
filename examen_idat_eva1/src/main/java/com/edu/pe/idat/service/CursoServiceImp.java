package com.edu.pe.idat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.idat.dto.CursoRequestDTO;
import com.edu.pe.idat.dto.CursoResponseDTO;
import com.edu.pe.idat.model.Curso;
import com.edu.pe.idat.repository.CursoRepository;

@Service
public class CursoServiceImp implements CursoService{

	@Autowired
	private CursoRepository repository;
	
	
	@Override
	public void guardarCurso(CursoRequestDTO c) {
		Curso curso = new Curso();
		curso.setIdCurso(c.getIdRequest());
		curso.setCurso(c.getCurso());
		curso.setDescripcion(c.getDescripcion());
		repository.save(curso);
		
	}

	@Override
	public void eliminarCurso(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public void editarProducto(CursoRequestDTO c) {
		
		Curso curso = new Curso();
		curso.setIdCurso(c.getIdRequest());
		curso.setCurso(c.getCurso());
		curso.setDescripcion(c.getDescripcion());
		repository.saveAndFlush(curso);
		
	}

	@Override
	public List<CursoResponseDTO> listarCursos() {
		List<Curso>cursos = repository.findAll();
		
		List<CursoResponseDTO>dto = new ArrayList<CursoResponseDTO>();
		CursoResponseDTO cursoDTO = null;
		
		for(Curso curso:cursos) {
			cursoDTO = new CursoResponseDTO();
			cursoDTO.setIdResponse(curso.getIdCurso());
			cursoDTO.setCurso(curso.getCurso());
			cursoDTO.setDescripcion(curso.getDescripcion());
			dto.add(cursoDTO);
		}		
		
				
		
		
		return dto;
	}

	@Override
	public CursoResponseDTO cursoById(Integer id) {
		
		Curso curso = repository.findById(id).orElse(null);
		CursoResponseDTO cursoDTO = new CursoResponseDTO();
		
		cursoDTO= new CursoResponseDTO();
		cursoDTO.setIdResponse(curso.getIdCurso());
		cursoDTO.setCurso(curso.getCurso());
		cursoDTO.setDescripcion(curso.getDescripcion());
		
		return cursoDTO;
	}

}
