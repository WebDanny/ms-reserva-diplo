package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ConversacionTest {
    @Test
    void testCheckCreate() {
        Conversacion conversation = new Conversacion();
        assertEquals(LocalDate.now(), conversation.getFechaInicio());
        assertEquals(null, conversation.getFechaFin());
        assertEquals("ACTIVA", conversation.getStatus().name());
    }

    @Test
    void testDeprecatedConversation() {
        Conversacion conversation = new Conversacion();
        conversation.deprecatedConversation();
        assertEquals("OLVIDADA", conversation.getStatus().name());
        assertEquals(LocalDate.now(), conversation.getFechaFin());
    }

    @Test
    void testException() {
        Conversacion conversation = new Conversacion();
        conversation.setStatus(StatusConversation.OLVIDADA);
        IllegalArgumentException execption = assertThrows(IllegalArgumentException.class, () -> {
            conversation.deprecatedConversation();
        });
        assertNotNull(execption);
    }
}