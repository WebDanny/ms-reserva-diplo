package com.nur.util;

import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Reserve;

import java.util.Date;
import java.util.UUID;

public class ReserveMapper {
    public static ReserveDTO from(Reserve reserve) {
        if (reserve == null) return new ReserveDTO();
        return new ReserveDTO(
                reserve.getId().toString(),
                reserve.getDateIn() == null ? new Date().toString() : reserve.getDateIn(),
                reserve.getDateOut() == null ? new Date().toString() : reserve.getDateOut(),
                reserve.getDetails() == null ? "" : reserve.getDetails(),
                reserve.getStatus() == null ? null : reserve.getStatus().name(),
                reserve.getPropiedadId() == null ? null : reserve.getPropiedadId(),
                reserve.getPersonaId() == null ? null : reserve.getPersonaId()
        );
    }

    public static Reserve from(ReserveDTO reserveDTO) throws BusinessRuleValidationException {
        return new Reserve(
                UUID.fromString(reserveDTO.getId()),
                reserveDTO.getDateIn(),
                reserveDTO.getDateOut(),
                reserveDTO.getDetails(),
                reserveDTO.getStatus(),
                reserveDTO.getPropiedad_id(),
                reserveDTO.getPersona_id()
        );
    }
}
