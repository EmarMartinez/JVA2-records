package com.bosonit.BD1crud.infraestructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public record PersonaInputDto ( String usuario,
                                String password,
                                String name,
                                String surname,
                                String company_email,
                                String personal_email,
                                String city,
                                boolean active,
                                Date created_date,
                                String imagen_url,
                                Date termination_date){





}
