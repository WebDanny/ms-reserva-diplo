package com.nur.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Reserve")
public class ReserveJpaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String persona_id;

    @Column(nullable = false)
    private String propiedad_id;

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

    public String getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(String persona_id) {
        this.persona_id = persona_id;
    }

    public String getPropiedad_id() {
        return propiedad_id;
    }

    public void setPropiedad_id(String propiedad_id) {
        this.propiedad_id = propiedad_id;
    }
}
