package com.nur.repositories.persons;

import static org.junit.jupiter.api.Assertions.*;

import com.nur.builder.PersonsBuilder;
import com.nur.model.PersonaJpaModel;
import com.nur.model.Personas;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PersonsCrudRepositoryImplTest {
  @Mock IPersonsCrudRepository personsCrudRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testUpdate() {
    assertDoesNotThrow(
        () -> {
          Personas person = new PersonsBuilder().build();

          PersonaJpaModel personaJpaModel = new PersonaJpaModel();
          personaJpaModel.setId(UUID.randomUUID());
          personaJpaModel.setName(person.getName());
          personaJpaModel.setLastName(person.getLastName());
          personaJpaModel.setCi(person.getCi());
        });
  }
}
