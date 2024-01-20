package com.nur.utils;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Reserve;
import com.nur.model.ReserveJpaModel;

public class ReserveUtils {
    public static ReserveJpaModel reserveToJpaEntity(Reserve reserve){
        ReserveJpaModel model = new ReserveJpaModel();
        model.setId(reserve.getId());
        model.setDateIn(reserve.getDateIn());
        model.setDateOut(reserve.getDateOut());
        model.setStatus(reserve.getStatus().name());
        model.setDetails(reserve.getDetails());
        model.setPropiedad(PropiedadUtils.propiedadToJpaEntity(reserve.getPropiedad())  );
        return model;
    }

    public static Reserve jpaToReserve(ReserveJpaModel jpaModel) throws BusinessRuleValidationException {
        return new Reserve(
                jpaModel.getId(),
                jpaModel.getDateIn(),
                jpaModel.getDateOut(),
                jpaModel.getDetails(),PropiedadUtils.jpaModelToPropiedad(jpaModel.getPropiedad())
        );
    }
}
