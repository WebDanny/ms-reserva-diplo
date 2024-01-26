package com.nur.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nur.annotations.Generated;

import java.util.List;

@Generated
public class PersonDTO {
    public String id;
    public String name;
    public String lastName;
    public String ci;
    public List<ReserveDTO> reservas;

    public List<ReserveDTO> getReservas() {
        return reservas;
    }

    public PersonDTO() {
    }

    public PersonDTO(String id, String name, String lastName, String ci, List<ReserveDTO> reservas) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.ci = ci;
        this.reservas = reservas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

}
