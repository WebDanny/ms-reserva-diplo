package com.nur.factories.reserve;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Propiedad;
import com.nur.model.Reserve;
import com.nur.model.StatusReserve;

import java.util.Date;
import java.util.UUID;

public interface IReserveFactory {
    Reserve createReserve(UUID id, String dateIn, String dateOut, String details, String status, String propiedadId, String personaId) throws BusinessRuleValidationException;
}
