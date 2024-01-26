package com.nur.dtos;

import com.nur.model.Persona;
import com.nur.model.Propiedad;

import java.util.Date;

public class ReserveDTO {
    public String id;
    public String dateIn;
    public String dateOut;
    public String details;

    public String status;
    public String propiedad_id;

    public String persona_id;

    public String getStatus() {
        return status;
    }

    public ReserveDTO() {
    }

    public ReserveDTO(String id, String dateIn, String dateOut, String details, String status, String propiedad_id, String persona_id) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.details = details;
        this.status = status;
        this.propiedad_id = propiedad_id;
        this.persona_id = persona_id;
    }

    public String getId() {
        return id;
    }


    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getDetails() {
        return details;
    }

    public String getPropiedad_id() {
        return propiedad_id;
    }

    public String getPersona_id() {
        return persona_id;
    }
}
