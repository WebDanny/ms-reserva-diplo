package com.nur.repositories;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Reserve;

import java.util.List;
import java.util.UUID;

public interface IReserveRepository {
    UUID create(Reserve reserve) throws BusinessRuleValidationException;
    Reserve getById(UUID id);
    List<Reserve> getAll() throws BusinessRuleValidationException;
}
