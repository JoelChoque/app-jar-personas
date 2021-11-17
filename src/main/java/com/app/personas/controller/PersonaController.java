package com.app.personas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.personas.dto.Persona;
import com.app.personas.dto.ResponseDto;
import com.app.personas.service.PersonaService;
import com.app.personas.utils.Constans;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService service;
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>>obtenerPersonas(){
		List<Persona> responsePersonas=service.obtenerPersonas();
		return new ResponseEntity<List<Persona>>(responsePersonas, HttpStatus.OK);
	}
	@PostMapping(value = "/agregar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto>crearPersona(@Valid @RequestBody Persona p,HttpServletRequest httRequest){
		ResponseDto response=new ResponseDto();
		try {
			service.guardarPersona(p);
			response.setCodigo(Constans.COD_OK_200);
			response.setMensaje(Constans.MSG_OK_200);
		} catch (Exception e) {
			response.setCodigo(Constans.COD_ERROR_400);
			response.setMensaje(Constans.MSG_ERROR_400);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping(value = "/modificar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto>modificarPersona(@Valid @RequestBody Persona p,HttpServletRequest httRequest){
		ResponseDto response=new ResponseDto();
		try {
			service.guardarPersona(p);
			response.setCodigo(Constans.COD_OK_200);
			response.setMensaje(Constans.MSG_OK_200);
		} catch (Exception e) {
			response.setCodigo(Constans.COD_ERROR_400);
			response.setMensaje(Constans.MSG_ERROR_400);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto>eliminarPersona(@Valid @RequestBody Persona p,HttpServletRequest httRequest){
		ResponseDto response=new ResponseDto();
		try {
			service.darBajaPersona(p.getId());
			response.setCodigo(Constans.COD_OK_200);
			response.setMensaje(Constans.MSG_OK_200);
		} catch (Exception e) {
			response.setCodigo(Constans.COD_ERROR_400);
			response.setMensaje(Constans.MSG_ERROR_400);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
