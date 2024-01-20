package com.nur.factories.persons;


import com.nur.model.Personas;

import java.util.UUID;

public class PersonaFactory implements IPersonaFactory{
    @Override
    public Personas createPerson(String name, String lastName, String ci) {
        return new Personas(name, lastName, ci);
    }
}
