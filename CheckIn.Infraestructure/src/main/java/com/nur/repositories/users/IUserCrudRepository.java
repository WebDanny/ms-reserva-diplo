package com.nur.repositories.users;

import com.nur.model.UserJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserCrudRepository extends JpaRepository<UserJpaModel, UUID> {
}
