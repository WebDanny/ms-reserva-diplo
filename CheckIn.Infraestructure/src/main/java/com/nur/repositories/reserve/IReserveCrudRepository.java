package com.nur.repositories.reserve;

import com.nur.model.ReserveJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IReserveCrudRepository extends JpaRepository<ReserveJpaModel, UUID> {

    List<ReserveJpaModel> findByPersonId(UUID id);
}
