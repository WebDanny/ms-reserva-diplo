package com.nur.factories.persons;

import com.nur.model.Persona;
import com.nur.model.Personas;
import com.nur.model.Reserve;

import java.util.List;

public interface IPersonaFactory {
    Personas createPerson(String name, String lastName, String ci, List<Reserve> reservas);
}
