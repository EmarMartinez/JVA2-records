package com.bosonit.BD1crud.application;

import com.bosonit.BD1crud.domain.Persona;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import com.bosonit.BD1crud.infraestructure.repository.PersonaJpa;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaJpa personaJpa;


    @Override
    public ResponseEntity<PersonaOutputDto> addPersona(PersonaInputDto personaInputDto){
        try {
            Persona persona = new Persona();
            personaJpa.save(persona.DtoToPersona(personaInputDto));
            return new ResponseEntity<>(persona.PersonaToDto(persona.DtoToPersona(personaInputDto)) , HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public ResponseEntity<PersonaOutputDto> buscarPorId(int id) {
        try {
            Persona persona = new Persona();
            return new ResponseEntity<>(persona.PersonaToDto(personaJpa.findById(id).get()), HttpStatus.OK);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<PersonaOutputDto>> buscarPorNombre(String nombre) {

        List<Persona> listaCoincidencias;
        listaCoincidencias = personaJpa.findAll().stream().filter(n-> n.getName().equalsIgnoreCase(nombre)).toList();
        return new ResponseEntity<>( listaCoincidencias.stream().map(n->n.PersonaToDto(n)).toList(),HttpStatus.OK);


    }

    @Override
    public ResponseEntity<List<PersonaOutputDto>> buscarTodos() {
        List<Persona> listaCompleta;
        listaCompleta = personaJpa.findAll().stream().toList();
        return new ResponseEntity<>(listaCompleta.stream().map(n->n.PersonaToDto(n)).toList(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonaOutputDto> modificarPorId(int id, PersonaInputDto personaInputDto) {
        try {
            Persona persona = new Persona();
            Persona personaMod = persona.DtoToPersona(personaInputDto);
            personaMod.setId(id);
            personaJpa.save(personaMod);
            return new ResponseEntity<>(persona.PersonaToDto(personaMod), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> borrarPorId(int id) {
        try {
            Persona persona = personaJpa.findById(id).get();
            personaJpa.delete(persona);
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
