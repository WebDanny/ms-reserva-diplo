package com.nur.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Reserve")
public class ReserveJpaModel {
    @Id
    @Column(name = "ID_RESERVE")
    private UUID id;

    @Column(nullable = false, name = "DATE_IN")
    private String dateIn;

    @Column(nullable = false, name = "DATE_OUT")
    private String dateOut;

    @Column(nullable = false, name = "STATUS")
    private String status;

    @Column(nullable = false, name = "DETAILS")
    private String details;


    @Column(nullable = false)
    private UUID personId;

    @Column(nullable = false)
    private UUID propiedadId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public UUID getPropiedadId() {
        return propiedadId;
    }

    public void setPropiedadId(UUID propiedadId) {
        this.propiedadId = propiedadId;
    }
}
