package com.nur.utils;

import com.nur.model.PersonaJpaModel;
import com.nur.model.Personas;

public class PersonsUtils {
    public static PersonaJpaModel personToJpaEntity(Personas person){
        PersonaJpaModel model = new PersonaJpaModel();
        model.setId(person.getId());
        model.setName(person.getName());
        model.setLastName(person.getLastName());
        model.setCi(person.getCi());
        return model;
    }

    public static Personas jpaToPersons(PersonaJpaModel jpaModel){
        return new Personas(
                jpaModel.getName(),
                jpaModel.getLastName(),
                jpaModel.getCi()
        );
    }
}
