package com.nur.factories.persons;

import com.nur.model.Personas;

public interface IPersonaFactory {
  Personas createPerson(String name, String lastName, String ci);
}
