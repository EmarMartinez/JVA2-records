package com.bosonit.BD1crud.infraestructure.controller;

import com.bosonit.BD1crud.application.PersonaServiceImpl;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPut {
    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @PutMapping("modificar/{id}")
    public ResponseEntity<PersonaOutputDto> modificarPorId(@PathVariable int id, @RequestBody PersonaInputDto personaInputDto) {
        return personaServiceImpl.modificarPorId(id, personaInputDto);
    }
}
