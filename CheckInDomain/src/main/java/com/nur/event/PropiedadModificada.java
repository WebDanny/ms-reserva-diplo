package com.nur.event;

import com.nur.core.DomainEvent;
import com.nur.model.Propiedad;


import java.time.LocalDate;
import java.util.Date;

public class PropiedadModificada extends DomainEvent {

    public Propiedad propiedadModificada;
    public PropiedadModificada(Propiedad propiedadModificada, Date occuredOn) {
        super(LocalDate.now());
        this.propiedadModificada = propiedadModificada;
    }
}
