package com.app.personas.service;

import java.util.List;

import com.app.personas.dto.Persona;

public interface PersonaService {	
	List<Persona>obtenerPersonas();
	Persona obtenerPersonaId(int id);
	void guardarPersona(Persona p);
	void darBajaPersona(int id);

}
