package com.nur.repositories.users;

import com.nur.model.UserJpaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserCrudRepository extends JpaRepository<UserJpaModel, UUID> {}
