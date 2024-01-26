package com.nur.factories.persons;


import com.nur.model.Personas;
import com.nur.model.Reserve;

import java.util.List;

public class PersonaFactory implements IPersonaFactory{
    @Override
    public Personas createPerson(String name, String lastName, String ci, List<Reserve> reservas) {
        return new Personas(name, lastName, ci, reservas);
    }
}
