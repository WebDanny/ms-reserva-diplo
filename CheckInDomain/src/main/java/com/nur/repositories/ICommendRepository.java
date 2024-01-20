package com.nur.repositories;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Commend;

import java.util.List;
import java.util.UUID;

public interface ICommendRepository {
    UUID update(Commend commend) throws BusinessRuleValidationException;
    Commend getById(UUID id);
    List<Commend> getAll();
}
