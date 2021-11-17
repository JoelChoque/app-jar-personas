package com.app.personas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.personas.dto.Persona;
import com.app.personas.persistence.PersonaRepository;
import com.app.personas.service.PersonaService;

@Component
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository repository;
	
	@Override
	public List<Persona> obtenerPersonas() {
		// TODO Auto-generated method stub
		return (List<Persona>)repository.findAll();
	}

	@Override
	public Persona obtenerPersonaId(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void guardarPersona(Persona p) {
		repository.save(p);
		
	}

	@Override
	public void darBajaPersona(int id) {
		repository.deleteById(id);
		
	}

}
