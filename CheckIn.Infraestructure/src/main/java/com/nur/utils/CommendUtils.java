package com.nur.utils;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Commend;
import com.nur.model.CommendJpaModel;

public class CommendUtils {
    public static CommendJpaModel commendToJpaEntity(Commend commend){
        CommendJpaModel model = new CommendJpaModel();
        model.setId(commend.getId());
        model.setCommend(commend.getComentario());
        model.setValoration(commend.getValoracion());
        model.setProperty(commend.getPropiedad());
        model.setPoints(commend.getPoints());
        model.setUserId(commend.getUserId());
        return model;
    }

    public static Commend jpaToCommend(CommendJpaModel jpaModel) throws BusinessRuleValidationException {
        return new Commend(
                jpaModel.getUserId(),
                jpaModel.getValoration(),
                jpaModel.getCommend(),
                jpaModel.getProperty(),
                jpaModel.getPoints()
        );
    }
}
