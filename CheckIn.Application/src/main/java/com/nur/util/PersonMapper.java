package com.nur.util;

import com.nur.dtos.PersonDTO;
import com.nur.model.Personas;

import java.util.UUID;

public class PersonMapper {
    public static PersonDTO from(Personas person){
        if(person == null) return new PersonDTO();
        return new PersonDTO(
                person.getId() == null ? String.valueOf(UUID.randomUUID()) : String.valueOf(person.getId()),
                person.getName() == null ? "" : person.getName(),
                person.getLastName() == null ? "" : person.getLastName(),
                person.getCi() == null ? "" : person.getCi()
        );
    }

    public static Personas from(PersonDTO person){
        return new Personas(
                person.getName(),
                person.getLastName(),
                person.getCi()
        );
    }
}
