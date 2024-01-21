package com.nur.repositories.reserve;

import com.nur.model.ReserveJpaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReserveCrudRepository extends JpaRepository<ReserveJpaModel, UUID> {}
