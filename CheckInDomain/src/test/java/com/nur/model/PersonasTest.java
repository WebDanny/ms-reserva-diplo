package com.nur.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PersonasTest {
    @Test
    void testPersonsCreate() {
        Personas person = new Personas("Cristhian", "Vargas", "1234567");
        assertEquals("Cristhian", person.getName());
        assertEquals("Vargas", person.getLastName());
        assertEquals("1234567", person.getCi());
    }

    @Test
    void testPersonEmptyCreate() {
        Personas person = new Personas();
        assertNotNull(person.getId());
        assertEquals(null, person.getCi());
        assertEquals(null, person.getName());
        assertEquals(null, person.getLastName());
    }
}