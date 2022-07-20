package com.bosonit.BD1crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador {
    @Autowired
    PersonaRepositorio personaRepositorio;

    @PostMapping("/persona")
    public Persona addPersona(@RequestBody Persona persona){
        try{
            persona.Validador();
            personaRepositorio.save(persona);
            return persona;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return persona;
        }

    }

    @GetMapping("id/{id}")
    public Persona buscarPorId(@PathVariable int id) throws Exception{
       try {
           return personaRepositorio.findById(id).get();
       }
       catch(Exception e) {
           System.out.println("No se encontró el ID");
           return null;
       }

    }
    @GetMapping("persona/{nombre}")
    public List<Persona> buscarPorNombre(@PathVariable String nombre){

            List<Persona> listaPersonas = new ArrayList<Persona>();
            List<Persona> listaMatch = new ArrayList<Persona>();
            listaMatch = personaRepositorio.findAll().stream().filter(n->n.getName().equalsIgnoreCase(nombre)).toList();
            return listaMatch;
    }

    @GetMapping("entradas")
    public List<Persona> listaCompleta() {
        List<Persona> lista = new ArrayList<Persona>();
        lista = personaRepositorio.findAll().stream().toList();
        return lista;
    }


    @PutMapping("persona/modificar")
    public Persona personaModificada(@RequestBody Persona persona) throws Exception{

        try {
            Persona personaMod = personaRepositorio.findById(persona.getId()).get();
            personaRepositorio.save(persona);
            return persona;
        }
        catch (Exception e) {
            System.out.println("El id a modificar no existe");
            return persona;

        }
    }
    @DeleteMapping("persona/borrar/{id}")
    public Persona borrarPersona(@PathVariable int id) throws Exception{
        try {
            Persona personatest = personaRepositorio.findById(id).get();
            personaRepositorio.deleteById(id);
            return personatest;
        }
        catch(Exception e) {
            System.out.println("No se encontro el ID");
            return null;
        }
    }


}
