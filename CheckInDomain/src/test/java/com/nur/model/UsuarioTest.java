package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    void testToCheckCreateUser() throws BusinessRuleValidationException {
        UUID personId = UUID.randomUUID();
        Usuario user = new Usuario("Cristhian", "cristhian_086@gmail.com", "1234567", "Huesped", personId);
        assertEquals("Cristhian", user.getUsername());
        assertEquals("cristhian_086@gmail.com", user.getEmail());
        assertEquals("1234567", user.getPass());
        assertEquals("Huesped", user.getAccountType());
        assertEquals(personId, user.getPersonId());
        assertNotNull(user.getPass());
        assertNotNull(user.getAccountType());
    }

    @Test
    void testCheckContructors() throws BusinessRuleValidationException {
        UUID personId = UUID.randomUUID();
        Usuario user = new Usuario("Cristhian", "cristhian_086@gmail.com", "1234567", "Huesped", personId);
        assertNotNull(user);

        assertThrows(BusinessRuleValidationException.class, () -> {
            new Usuario("Cristhian", "", "1234567", "Huesped", personId);
        });
    }
}