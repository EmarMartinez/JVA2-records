package com.bosonit.BD1crud.application;

import com.bosonit.BD1crud.domain.Persona;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {
    ResponseEntity<PersonaOutputDto> addPersona(PersonaInputDto personaInputDto);
    ResponseEntity<PersonaOutputDto> buscarPorId(int id);
    ResponseEntity<List<PersonaOutputDto>> buscarPorNombre(String nombre);
    ResponseEntity<List<PersonaOutputDto>> buscarTodos();
    ResponseEntity<PersonaOutputDto> modificarPorId(int id, PersonaInputDto personaInputDto);
    ResponseEntity<?> borrarPorId(int id);



}
