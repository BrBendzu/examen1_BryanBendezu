package com.edu.pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.pe.idat.dto.CursoRequestDTO;
import com.edu.pe.idat.dto.CursoResponseDTO;
import com.edu.pe.idat.service.CursoService;

@RestController
@RequestMapping("/curso/v1")
public class CursoController {

	@Autowired
	private CursoService service;
	
	@RequestMapping(method=RequestMethod.GET,path="listar")
	public ResponseEntity<List<CursoResponseDTO>>listar(){
		
		return new ResponseEntity<List<CursoResponseDTO>>(service.listarCursos(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST,path="/guardar")
	public ResponseEntity<Void>guardar(@RequestBody CursoRequestDTO curso){
		service.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method= RequestMethod.GET,path="/listar/{id}")
	public @ResponseBody ResponseEntity<CursoResponseDTO>cursobyId(@PathVariable Integer Id){
		CursoResponseDTO curso = service.cursoById(Id);
		if(curso != null) {
			return new ResponseEntity<CursoResponseDTO>(curso,HttpStatus.OK);
			
		}
		return new ResponseEntity<CursoResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(method= RequestMethod.DELETE, path="/eliminar/{id}")
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		CursoResponseDTO curso = service.cursoById(id);
		if(curso != null) {
			service.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,path="/editar")
	public ResponseEntity<Void>editar(@RequestBody CursoRequestDTO curso){
		CursoResponseDTO cur = service.cursoById(curso.getIdRequest());
		
		if(cur != null) {
			service.editarProducto(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
}
