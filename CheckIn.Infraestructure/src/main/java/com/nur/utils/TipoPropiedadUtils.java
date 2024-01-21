package com.nur.utils;

import com.nur.core.BusinessRuleValidationException;
import com.nur.model.TipoPropiedad;
import com.nur.model.TipoPropiedadJpaModel;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TipoPropiedadUtils {

  public static TipoPropiedadJpaModel tipoToJpaEntity(TipoPropiedad tipo) {
    if (tipo == null) return null;
    TipoPropiedadJpaModel tipoPropiedadJpaModel = new TipoPropiedadJpaModel();
    tipoPropiedadJpaModel.setId(tipo.getId());
    tipoPropiedadJpaModel.setNombreTipo(tipo.getNombreTipo());
    return tipoPropiedadJpaModel;
  }

  public static List<TipoPropiedadJpaModel> seatsToJpaEntities(List<TipoPropiedad> tipo) {
    if (tipo == null) return Collections.emptyList();
    return tipo.stream().map(TipoPropiedadUtils::tipoToJpaEntity).collect(Collectors.toList());
  }

  public static TipoPropiedad jpaModelToTipoPropiedad(TipoPropiedadJpaModel jpaModel)
      throws BusinessRuleValidationException {
    return new TipoPropiedad(jpaModel.getId(), jpaModel.getNombreTipo());
  }
}
