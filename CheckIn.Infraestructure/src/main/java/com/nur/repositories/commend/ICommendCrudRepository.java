package com.nur.repositories.commend;

import com.nur.model.CommendJpaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommendCrudRepository extends JpaRepository<CommendJpaModel, UUID> {}
