package com.nur.factories.reserve;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Propiedad;
import com.nur.model.Reserve;
import com.nur.model.StatusReserve;

import java.util.Date;

public class ReserveFactory implements IReserveFactory{
    @Override
    public Reserve createReserve(Date dateIn, Date dateOut, String details, Propiedad propiedad) throws BusinessRuleValidationException {
        return new Reserve(dateIn,dateOut,details,propiedad);
    }
}
