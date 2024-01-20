package com.nur.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Reserve")
public class ReserveJpaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_RESERVE")
    private UUID id;

    @Column(nullable = false, name = "DATE_IN")
    private Date dateIn;

    @Column(nullable = false, name = "DATE_OUT")
    private Date dateOut;

    @Column(nullable = false, name = "STATUS")
    private String status;

    @Column(nullable = false, name = "DETAILS")
    private String details;

    @OneToOne(optional = true)
    private PropiedadJpaModel propiedad;

    @OneToOne(optional = true)
    private PersonaJpaModel persona;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
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

    public PropiedadJpaModel getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(PropiedadJpaModel propiedad) {
        this.propiedad = propiedad;
    }

    public PersonaJpaModel getPersona() {
        return persona;
    }

    public void setPersona(PersonaJpaModel persona) {
        this.persona = persona;
    }
}
