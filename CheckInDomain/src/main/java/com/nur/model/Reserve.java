package com.nur.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nur.core.BusinessRuleValidationException;
import com.nur.core.Entity;
import com.nur.valueObjects.DateValueObject;

import java.util.Date;
import java.util.UUID;

public class Reserve extends Entity {

    @JsonProperty("dateIn")
    public Date dateIn;

    @JsonProperty("dateOut")
    public Date dateOut;

    @JsonProperty("status")
    public StatusReserve status;

    @JsonProperty("details")
    public String details;

    @JsonProperty("propiedad")
    public Propiedad propiedad;

    public void setStatus(StatusReserve status) {
        this.status = status;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public String getDetails() {
        return details;
    }

    public StatusReserve getStatus() {
        return status;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }


    public Reserve(Date dateIn, Date dateOut, String details, Propiedad propiedad) throws BusinessRuleValidationException {
        new DateValueObject(dateIn,dateOut);
        id = UUID.randomUUID();
        this.dateIn = dateIn;
        this.status = StatusReserve.RESERVE;
        this.dateOut = dateOut;
        this.details = details;
        this.propiedad = propiedad;
    }

    public Reserve(UUID id,Date dateIn, Date dateOut, String details, Propiedad propiedad)  {
        setId(id);
        this.dateIn = dateIn;
        this.status = StatusReserve.RESERVE;
        this.dateOut = dateOut;
        this.details = details;
        this.propiedad = propiedad;
    }



    public Reserve() {
    }
}
