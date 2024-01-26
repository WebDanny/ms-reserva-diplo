package com.nur.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nur.core.BusinessRuleValidationException;
import com.nur.core.Entity;
import com.nur.valueObjects.DateValueObject;

import java.util.Date;
import java.util.UUID;

public class Reserve extends Entity {

    @JsonProperty("dateIn")
    public String dateIn;

    @JsonProperty("dateOut")
    public String dateOut;

    @JsonProperty("status")
    public StatusReserve status;

    @JsonProperty("details")
    public String details;

    @JsonProperty("propiedadId")
    public String propiedadId;

    public Reserve(UUID id, String dateIn, String dateOut, String status, String details, String propiedadId, String personaId) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.status = StatusReserve.RESERVE;
        this.details = details;
        this.propiedadId = propiedadId;
        this.personaId = personaId;
    }

    @JsonProperty("personaId")
    public String personaId;

    public void setStatus(StatusReserve status) {
        this.status = status;
    }


    public String getDateIn() {
        return dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public String getDetails() {
        return details;
    }

    public StatusReserve getStatus() {
        return status;
    }

    public String getPropiedadId() {
        return propiedadId;
    }

    public String getPersonaId() {
        return personaId;
    }




    public Reserve() {
    }
}
