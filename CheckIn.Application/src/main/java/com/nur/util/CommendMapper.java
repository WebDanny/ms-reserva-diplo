package com.nur.util;

import com.nur.core.BusinessRuleValidationException;
import com.nur.dtos.CommendDTO;
import com.nur.model.Commend;

import java.util.UUID;

public class CommendMapper {
    public static CommendDTO from(Commend commends){
        if(commends == null) return new CommendDTO();
        return new CommendDTO(
                String.valueOf(commends.getId()),
                String.valueOf(commends.getUserId()),
                commends.getValoracion(),
                commends.getComentario(),
                commends.getPropiedad(),
                commends.getPoints()
        );
    }

    public static Commend from(CommendDTO commends) throws BusinessRuleValidationException {
        return new Commend(
                UUID.fromString(commends.getUserId()),
                commends.getValoration(),
                commends.getDescription(),
                commends.getProperty(),
                commends.getPoints()
        );
    }
}
