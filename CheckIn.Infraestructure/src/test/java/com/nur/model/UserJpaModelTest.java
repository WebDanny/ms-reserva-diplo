package com.nur.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class UserJpaModelTest {
  @Test
  void testUserJpaModelCreation() {
    PersonaJpaModel person = new PersonaJpaModel();
    person.setId(UUID.randomUUID());

    UserJpaModel users = new UserJpaModel();
    users.setId(UUID.randomUUID());
    users.setUsername("Criss123");
    users.setEmail("cristhian@gmail.com");
    users.setPassword("123456");
    users.setAccountType("Huesped");
    users.setPersonId(UUID.randomUUID());

    assertTrue(users.getId().version() == 4);
    assertTrue(users.getPersonId().version() == 4);
    assertEquals("Criss123", users.getUsername());
    assertEquals("cristhian@gmail.com", users.getEmail());
    assertEquals("123456", users.getPassword());
    assertEquals("Huesped", users.getAccountType());
  }
}
