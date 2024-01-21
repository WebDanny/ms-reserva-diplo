package com.nur.event;

import com.nur.core.DomainEvent;
import com.nur.model.Propiedad;
import java.time.LocalDate;
import java.util.Date;

public class PropiedadEliminado extends DomainEvent {
  public Propiedad propiedadEliminada;

  public PropiedadEliminado(Propiedad propiedadEliminada, Date occuredOn) {
    super(LocalDate.now());
    this.propiedadEliminada = propiedadEliminada;
  }
}
