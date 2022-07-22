package com.bosonit.BD1crud.infraestructure.controller;

import com.bosonit.BD1crud.application.PersonaService;
import com.bosonit.BD1crud.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorPost {

    @Autowired
    PersonaService personaservice;

    @PostMapping("/persona")
    public ResponseEntity<PersonaOutputDto> crearPersona(@RequestBody PersonaInputDto personaInputDto){
        return personaservice.addPersona(personaInputDto);
    }
}
