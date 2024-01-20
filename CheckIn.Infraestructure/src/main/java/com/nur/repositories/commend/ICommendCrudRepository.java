package com.nur.repositories.commend;

import com.nur.model.CommendJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICommendCrudRepository extends JpaRepository<CommendJpaModel, UUID> {
}
