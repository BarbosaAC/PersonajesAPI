package com.generation20.parsonajesapi.error;

@SuppressWarnings("serial")
public class PersonajeNotFoundException extends RuntimeException {


	public PersonajeNotFoundException(Integer id) {
		super(String.format("Personaje no encontrado con el id: %s", id));
	}
}
