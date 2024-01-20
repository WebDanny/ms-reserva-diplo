package com.nur.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonaJpaModelTest {
    @Test
    void testPersonJpaModelCreation() {
        PersonaJpaModel jpaPerson = new PersonaJpaModel();
        jpaPerson.setId(UUID.randomUUID());
        jpaPerson.setName("Cristhian");
        jpaPerson.setLastName("Vargas");
        jpaPerson.setCi("1234567");

        assertTrue(jpaPerson.getId().version() == 4);
        assertEquals("Cristhian", jpaPerson.getName());
        assertEquals("Vargas", jpaPerson.getLastName());
        assertEquals("1234567", jpaPerson.getCi());
    }
}