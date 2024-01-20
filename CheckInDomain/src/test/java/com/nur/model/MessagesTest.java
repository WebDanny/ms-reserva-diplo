package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MessagesTest {

    @Test
    void testCheckCreateMessage() {
        UUID userID = UUID.randomUUID();
        UUID conversationId = UUID.randomUUID();
        Messages message = new Messages(
                userID, "lo que sea", conversationId
        );
        message.setUserId(userID);
        message.setConversacionId(conversationId);
        assertEquals("lo que sea", message.getDescription());
        assertEquals("VIGENTE", message.getStatus().name());
        assertNotNull(message.getUserId());
        assertNotNull(message.getConversacionId());
    }

    @Test
    void testAnularMessage() {
        UUID userID = UUID.randomUUID();
        UUID conversationId = UUID.randomUUID();
        Messages message = new Messages(
                userID, "lo que sea", conversationId
        );
        message.setUserId(userID);
        message.setConversacionId(conversationId);
        assertDoesNotThrow(() -> {
            message.anularMensaje(message.getId());
            assertEquals("ANULADO", message.getStatus().name());
        });
    }

    @Test
    void testCheckException() {
        UUID userID = UUID.randomUUID();
        UUID conversationId = UUID.randomUUID();
        Messages message = new Messages(
                userID, "lo que sea", conversationId
        );
        BusinessRuleValidationException exception = assertThrows(BusinessRuleValidationException.class, () -> {
            message.anularMensaje(null);
        });
        assertEquals("Error anulando mensaje", exception.getMessage());

    }
}