package com.nur.repositories.persons;

import com.nur.model.PersonaJpaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonsCrudRepository extends JpaRepository<PersonaJpaModel, UUID> {}
