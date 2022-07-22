package com.bosonit.BD1crud.domain;

import com.bosonit.BD1crud.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data

public class Persona {
    @Id
    @GeneratedValue
    private int id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    public void Validador() throws Exception{

        if(usuario == null || usuario.length()<6 || usuario.length() > 10 )
        {

            throw new RuntimeException("El usuario no puede ser null, y tiene que tener entre 6 y 10 caracteres");


        }
        if(password == null )
        {
            throw new RuntimeException("El password no puede ser null");
        }
        if(name == null )
        {
            throw new RuntimeException("El nombre no puede ser null");
        }
        if(company_email == null )
        {
            throw new RuntimeException("El email no puede ser null");
        }
        if(personal_email == null )
        {
            throw new RuntimeException("El email no puede ser null");
        }
        if(city == null )
        {
            throw new RuntimeException("La ciudad no puede ser null");
        }
        if(created_date == null )
        {
            throw new RuntimeException("La fecha no puede ser null");
        }


    }
    public Persona DtoToPersona(PersonaInputDto personaInputDto) throws Exception{
        try {
            Persona persona = new Persona();
            persona.setUsuario(personaInputDto.getUsuario());
            persona.setPassword(personaInputDto.getPassword());
            persona.setName(personaInputDto.getName());
            persona.setSurname(personaInputDto.getSurname());
            persona.setCompany_email(personaInputDto.getCompany_email());
            persona.setPersonal_email(personaInputDto.getPersonal_email());
            persona.setCity(personaInputDto.getCity());
            persona.setActive(personaInputDto.isActive());
            persona.setCreated_date(personaInputDto.getCreated_date());
            persona.setImagen_url(personaInputDto.getImagen_url());
            persona.setTermination_date(personaInputDto.getTermination_date());
            persona.Validador();
            return persona;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public PersonaOutputDto PersonaToDto(Persona persona) {

        PersonaOutputDto personaOutputDto = new PersonaOutputDto();
        personaOutputDto.setUsuario(persona.getUsuario());
        personaOutputDto.setPassword(persona.getPassword());
        personaOutputDto.setName(persona.getName());
        personaOutputDto.setSurname(persona.getSurname());
        personaOutputDto.setCompany_email(persona.getCompany_email());
        personaOutputDto.setPersonal_email(persona.getPersonal_email());
        personaOutputDto.setCity(persona.getCity());
        personaOutputDto.setActive(persona.isActive());
        personaOutputDto.setCreated_date(persona.getCreated_date());
        personaOutputDto.setImagen_url(persona.getImagen_url());
        personaOutputDto.setTermination_date(persona.getTermination_date());
        return personaOutputDto;
    }

}
