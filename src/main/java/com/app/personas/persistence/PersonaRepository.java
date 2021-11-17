package com.app.personas.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.personas.dto.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer>{
	
}
