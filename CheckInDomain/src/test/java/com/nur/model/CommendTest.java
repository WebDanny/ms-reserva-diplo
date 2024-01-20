package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommendTest {
    @Test
    void testCheckCreateCommend() throws BusinessRuleValidationException {
        UUID userId = UUID.randomUUID();
        Commend commend = new Commend(
                UUID.fromString(String.valueOf(userId)),
                "Buena",
                "lo que sea",
                "Condominio",
                3
        );
        commend.setUserId(userId);
        assertEquals("Buena", commend.getValoracion());
        assertEquals("lo que sea", commend.getComentario());
        assertEquals("Condominio", commend.getPropiedad());
        assertEquals(3, commend.getPoints());
        assertNotNull(commend.getUserId());
        assertNotNull(commend.getId());
    }
}