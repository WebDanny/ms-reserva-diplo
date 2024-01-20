package com.nur.model;

import com.nur.core.BusinessRuleValidationException;
import com.nur.core.Entity;
import com.nur.valueObjects.ValorationValueObject;

import java.util.UUID;


public class Commend extends Entity {
    public UUID userId;
    public String valoracion;
    public String comentario;
    public String propiedad;
    public ValorationValueObject points;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getValoracion() {
        return valoracion;
    }


    public String getComentario() {
        return comentario;
    }


    public String getPropiedad() {
        return propiedad;
    }


    public int getPoints() {
        return points.getPoints();
    }


    public Commend(UUID userId, String valoracion, String comentario, String propiedad, int points) throws BusinessRuleValidationException {
        id = UUID.randomUUID();
        this.userId = userId;
        this.valoracion = valoracion;
        this.comentario = comentario;
        this.propiedad = propiedad;
        this.points = new ValorationValueObject(points);
    }
}
