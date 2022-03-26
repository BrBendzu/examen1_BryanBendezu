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

import com.edu.pe.idat.dto.MallaRequestDTO;
import com.edu.pe.idat.dto.MallaResponseDTO;
import com.edu.pe.idat.service.MallaCurricularService;

@RestController
@RequestMapping("/malla/v1")
public class MallaController {
	
	@Autowired
	private MallaCurricularService service;
	
	@RequestMapping(method=RequestMethod.GET,path="listar")
	public ResponseEntity<List<MallaResponseDTO>>listar(){
		
		return new ResponseEntity<List<MallaResponseDTO>>(service.listarMallaCurricular(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST,path="/guardar")
	public ResponseEntity<Void>guardar(@RequestBody MallaRequestDTO malla){
		service.guardarMallaCurricular(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method= RequestMethod.GET,path="/listar/{id}")
	public @ResponseBody ResponseEntity<MallaResponseDTO>MallabyId(@PathVariable Integer Id){
		MallaResponseDTO curso = service.MallaCurricularById(Id);
		if(curso != null) {
			return new ResponseEntity<MallaResponseDTO>(curso,HttpStatus.OK);
			
		}
		return new ResponseEntity<MallaResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		MallaResponseDTO product = service.MallaCurricularById(id);
		if(product != null) {
			service.eliminarMallCurricular(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody MallaRequestDTO malla){
		MallaResponseDTO ma = service.MallaCurricularById(malla.getIdRequest());
		if(ma != null) {
			service.editarMallCurricular(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	

}
