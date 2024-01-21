package com.nur.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

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
    IllegalArgumentException execption =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              conversation.deprecatedConversation();
            });
    assertNotNull(execption);
  }
}
