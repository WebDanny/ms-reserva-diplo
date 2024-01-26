package com.nur.factories.reserve;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Propiedad;
import com.nur.model.Reserve;
import com.nur.model.StatusReserve;

import java.util.Date;
import java.util.UUID;

public class ReserveFactory implements IReserveFactory{
    @Override
    public Reserve createReserve(UUID id,String dateIn, String dateOut, String status, String details, String propiedadId, String personaId) throws BusinessRuleValidationException {
        return new Reserve(id,dateIn,dateOut,details,status,propiedadId,personaId);
    }
}
