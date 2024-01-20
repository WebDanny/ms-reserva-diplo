package com.nur.util;

import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.PersonDTO;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Personas;
import com.nur.model.Reserve;

import java.util.Date;
import java.util.UUID;

public class ReserveMapper {
    public static ReserveDTO from(Reserve reserve) {
        if (reserve == null) return new ReserveDTO();
        return new ReserveDTO(
                reserve.getId().toString(),
                reserve.getDateIn() == null ? new Date() : reserve.getDateIn(),
                reserve.getDateOut() == null ? new Date() : reserve.getDateOut(),
                reserve.getDetails() == null ? "" : reserve.getDetails(),
                reserve.getPropiedad() == null ? null : reserve.getPropiedad()
        );
    }

    public static Reserve from(ReserveDTO reserveDTO) throws BusinessRuleValidationException {
        return new Reserve(
                UUID.fromString(reserveDTO.getId()),
                reserveDTO.getDateIn(),
                reserveDTO.getDateOut(),
                reserveDTO.getDetails(),
                reserveDTO.getPropiedad()
        );
    }
}
