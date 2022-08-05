package com.bosonit.BD1crud.domain;

import com.bosonit.BD1crud.infraestructure.controller.dto.input.PersonaInputDto;
import com.bosonit.BD1crud.infraestructure.controller.dto.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
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

    public Persona(String usuario, String password, String name, String surname, String company_email, String personal_email, String city, boolean active, Date created_date, String imagen_url, Date termination_date) {
        this.usuario = usuario;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.active = active;
        this.created_date = created_date;
        this.imagen_url = imagen_url;
        this.termination_date = termination_date;
    }

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
            Persona persona = new Persona(
                    personaInputDto.usuario(),
                    personaInputDto.password(),
                    personaInputDto.name(),
                    personaInputDto.surname(),
                    personaInputDto.company_email(),
                    personaInputDto.personal_email(),
                    personaInputDto.city(),
                    personaInputDto.active(),
                    personaInputDto.created_date(),
                    personaInputDto.imagen_url(),
                    personaInputDto.termination_date()
                    );

            persona.Validador();
            return persona;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public PersonaOutputDto PersonaToDto(Persona persona) {


        return new PersonaOutputDto(
                persona.getUsuario(),
                persona.getPassword(),
                persona.getName(),
                persona.getSurname(),
                persona.getCompany_email(),
                persona.getPersonal_email(),
                persona.getCity(),
                persona.isActive(),
                persona.getCreated_date(),
                persona.getImagen_url(),
                persona.getTermination_date()
                );
    }

}
