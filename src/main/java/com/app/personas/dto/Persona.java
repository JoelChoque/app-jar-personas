package com.app.personas.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(max = 8, message = "DNI máximo 8 caracteres")
	@NotBlank(message = "DNI no puede ir vacio")
	private String dni;
	@NotBlank(message = "Nombres no puede ir vacio")
	private String nombres;
	
	@Size(min = 2,max = 2, message = "Permitido 2 caracteres")
	@NotNull(message = "Es Empleado Si/No no puede ir vacio o Nulo")
	private String isEmpleado; 
}
