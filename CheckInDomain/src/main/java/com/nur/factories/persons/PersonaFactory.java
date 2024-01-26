package com.nur.factories.persons;


import com.nur.model.Personas;
import com.nur.model.Reserve;

import java.util.List;

public class PersonaFactory implements IPersonaFactory{
    @Override
    public Personas createPerson(String name, String lastName, String ci) {
        return new Personas(name, lastName, ci);
    }
}
