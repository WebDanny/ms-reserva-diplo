package com.nur.repositories.persons;

import com.nur.model.PersonaJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPersonsCrudRepository extends JpaRepository<PersonaJpaModel, UUID> {
}
