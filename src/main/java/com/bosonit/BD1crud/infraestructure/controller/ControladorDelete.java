package com.bosonit.BD1crud.infraestructure.controller;

import com.bosonit.BD1crud.application.PersonaServiceImpl;
import com.bosonit.BD1crud.infraestructure.repository.PersonaJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorDelete {
    @Autowired
    PersonaServiceImpl personaServiceImpl;

    @DeleteMapping("borrar/{id}")
    public void borrarPorId(@PathVariable int id) {
        personaServiceImpl.borrarPorId(id);

    }
}
